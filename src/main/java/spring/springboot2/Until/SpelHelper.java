/*
 * @(#)SpelHelper.java 1.0 2019年6月1日
 *
 * Copyright 2014-2019 jd jr All Rights Reserved.
 * PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 * Author Email: liyuliang5@jd.com
 */
package spring.springboot2.Until;

import org.springframework.context.ApplicationContext;
import org.springframework.context.expression.BeanFactoryResolver;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.ParserContext;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Helper class used to evaluate SpEL expression.
 *
 * @author
 */
public class SpelHelper {

    public static StandardEvaluationContext context = new StandardEvaluationContext();

    private static Map<String, Expression> cacheMap = new ConcurrentHashMap();

    private static Map<String, Expression> tmpCacheMap = new ConcurrentHashMap();

    private static Map<String, String> safePropertyMap = new ConcurrentHashMap<String, String>();

    private static ExpressionParser parser = new SpelExpressionParser();

    private static ApplicationContext applicationContext;

    /**
     * 后端先将json序列化为一个map，然后将这个map作为root对象进行el解析
     */
    /**
     *采用el表达式进行解析，针对map的解析写法比较复杂：map['student']['address']['city']
     * 以上写法不优雅，为了更优雅的兼容map解析，需要对原有的StandardEvaluationContext添加一个属性访问器：MapAccessor
     * 这样就可以通过如下写法获取属性：
     *map.student.address.city
     */
    static {
        context.addPropertyAccessor(new MapAccessor());
    }

    public static void clearCache() {
        cacheMap.clear();
        tmpCacheMap.clear();
        safePropertyMap.clear();
    }

    public static Expression parse(String exp) {
        return parser.parseExpression(exp);
    }

    public static <T> T safeGetProperty(String exp, Object context) {
        if (context == null) {
            return null;
        }
        return (T) safeGetProperty(exp, context, true);
    }

    public static <T> T safeGetProperty(String exp, Object context, boolean cache) {
        if (exp == null) {
            return null;
        }
        if (!cache) {
            String safeExp = getSafePropertyExp(exp);
            return (T) eval(safeExp, context, false);
        } else {
            String safeExp = safePropertyMap.get(exp);
            if (safeExp == null) {
                safeExp = getSafePropertyExp(exp);
                safePropertyMap.put(exp, safeExp);
            }
            return (T) eval(safeExp, context, true);
        }

    }

    private static String getSafePropertyExp(String exp) {
        String[] values = exp.split("\\.");
        StringBuffer buffer = new StringBuffer();
        for (String s : values) {
            buffer.append(s).append("?.");
        }
        return buffer.substring(0, buffer.length() - 2);
    }

    public static <T> T eval(Expression exp, Object context) {
        Object value = exp.getValue(context);
        return (T) value;
    }

    public static <T> T evalWithDefaultContext(String exp, Object root, boolean cache) {
        return eval(exp, context, root, cache);
    }

    public static <T> T eval(String exp, Object context) {
        return (T) eval(exp, context, true);
    }

    public static <T> T eval(String exp, Object context, boolean cache) {
        Expression expression;
        if (cache) {
            expression = cacheMap.get(exp);
            if (expression == null) {
                expression = parse(exp);
                cacheMap.put(exp, expression);
            }
        } else {
            expression = parse(exp);
        }

        Object value = null;
        if (context instanceof EvaluationContext) {
            value = expression.getValue((EvaluationContext) context);
        } else {
            value = expression.getValue(context);
        }
        return (T) value;
    }

    public static <T> T eval(String exp, EvaluationContext context, Object root, boolean cache) {
        Expression expression;
        if (cache) {
            expression = cacheMap.get(exp);
            if (expression == null) {
                expression = parse(exp);
                cacheMap.put(exp, expression);
            }
        } else {
            expression = parse(exp);
        }

        Object value = expression.getValue(context, root);
        return (T) value;
    }

    public static Expression parseTemplate(String template) {
        return parser.parseExpression(template, ParserContext.TEMPLATE_EXPRESSION);
    }

    public static String evalTemplate(Expression template, Object context) {
        return (String) template.getValue(context);
    }

    public static String evalTemplate(String template, Object context) {
        return evalTemplate(template, context, true);
    }

    public static String evalTemplate(String template, Object context, boolean cache) {
        Expression expression;
        if (cache) {
            expression = tmpCacheMap.get(template);
            if (expression == null) {
                expression = parseTemplate(template);
                tmpCacheMap.put(template, expression);
            }
        } else {
            expression = parseTemplate(template);
        }
        Object result = null;
        if (context instanceof EvaluationContext) {
            result = expression.getValue((EvaluationContext) context);
        } else {
            result = expression.getValue(context);
        }
        if (result == null) {
            return null;
        }
        return result.toString();
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpelHelper.applicationContext = applicationContext;
        context.setBeanResolver(new BeanFactoryResolver(applicationContext));
    }

}
