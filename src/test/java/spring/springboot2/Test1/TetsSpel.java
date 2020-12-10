package spring.springboot2.Test1;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang.time.FastDateFormat;
import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

import spring.springboot2.Until.SpelHelper;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/17 16:10
 * @Description
 */
public class TetsSpel {

    public static void main1(String[] args) {
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        // 属性读取
        // key value
        ctx.addPropertyAccessor(new MapAccessor());

        String exp = "new spring.springboot2.Test1.WorkeService().run(param)";

        Map<String, Object> root = new HashMap<>();
        root.put("param", "test");
        // root 执行表达式的对象
        // exp 在root中获取参数
        Object result = SpelHelper.eval(exp, ctx, root, true);

        System.out.println(result);

    }

    public static void main11(String[] args) {
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ExpressionParser parser = new SpelExpressionParser();

        Expression expression = parser.parseExpression("new spring.springboot2.Test1.WorkeService().run()");
        Map<String, Object> map = new HashMap<>();
        // 执行表达式对象map
        // 执行表达式的根对象
        Object value = expression.getValue(ctx, map);
        System.out.println(value);
    }

    public static void main(String[] args) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate parse = LocalDate.parse("2014-10-22");
        System.out.println(parse);
        Date date = new Date();
        // Calendar calendar = Calendar.getInstance();
        // calendar.setTime(date);
        // calendar.add(Calendar.YEAR, 1);
        // date = calendar.getTime();
        // System.out.println(date);
        FastDateFormat sdf = FastDateFormat.getInstance("yyyy-MM-dd");
        System.out.println(sdf.format(date));
    }
}
