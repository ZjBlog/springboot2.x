package spring.springboot2.Test1;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 16:10
 * @Description
 */
public class TetsSpel {

    public static void main(String[] args) {
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();


        Expression expression = parser.parseExpression("new spring.springboot2.Test1.WorkeService().run()");
        Map<String, Object> map = new HashMap<>();
        //执行表达式对象map
        //执行表达式的根对象
        Object value = expression.getValue(ctx, map);
        System.out.println(value);
    }
}
