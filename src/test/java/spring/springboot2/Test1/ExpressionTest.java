package spring.springboot2.Test1;

import org.springframework.context.expression.MapAccessor;
import org.springframework.expression.EvaluationContext;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;
import spring.springboot2.entity.Address;
import spring.springboot2.entity.Student;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/25 18:15
 * @Description
 */
public class ExpressionTest {

    public static void main(String[] args) {

//        EvaluationContext context=new StandardEvaluationContext();
//
//        ExpressionParser parser = new SpelExpressionParser();
//        Expression expression = parser.parseExpression("6+2");
//        Integer result = (Integer) expression.getValue(context);
//        System.out.println("result:" + result);

        ExpressionParser parser = new SpelExpressionParser();

        Address person = new Address();
        person.setAdd("========");
        List<String> list = new ArrayList<String>() {{
            add("fsx");
            add("周杰伦");
        }};
        Map<String, Integer> map = new HashMap<String, Integer>() {{
            put("fsx", 18);
            put("周杰伦", 40);
        }};

        //EvaluationContext ctx = new StandardEvaluationContext();
        StandardEvaluationContext ctx = new StandardEvaluationContext();
        ctx.addPropertyAccessor(new MapAccessor());

        //把list和map都放进环境变量里面去
        ctx.setVariable("myPerson", person);
        ctx.setVariable("myList", list);
        ctx.setVariable("myMap", map);


        //============================================
        System.out.println(parser.parseExpression("#myPerson").getValue(ctx)); //Person{name='fsx', age=30}
        System.out.println(parser.parseExpression("#myPerson.add").getValue(ctx)); //fsx
        // setVariable方式取值不能像root一样，前缀不可省略~~~~~
        System.out.println(parser.parseExpression("#name").getValue(ctx)); //null 显然找不到这个key就返回null呗~~~
        // 不写前缀默认去root找，找出一个null。再访问name属性那可不报错了吗
        //System.out.println(parser.parseExpression("name").getValue(ctx)); // Property or field 'name' cannot be found on null


        System.out.println(parser.parseExpression("#myList").getValue(ctx)); // [fsx, 周杰伦]
        System.out.println(parser.parseExpression("#myList[1]").getValue(ctx)); // 周杰伦

        // 请注意对Map取值两者的区别：中文作为key必须用''包起来   当然['fsx']也是没有问题的
        System.out.println(parser.parseExpression("#myMap[fsx]").getValue(ctx)); //18
        System.out.println(parser.parseExpression("#myMap['周杰伦']").getValue(ctx)); //40

        // =========若采用#key引用的变量不存在，返回的是null，并不会报错哦==============
        System.out.println(parser.parseExpression("#map").getValue(ctx)); //null

        // 黑科技：SpEL内直接可以使用new方式创建实例  能创建数组、List  但不能创建普通的实例对象（难道是我还不知道）~~~~
        System.out.println(parser.parseExpression("new String[]{'java','spring'}").getValue()); //[Ljava.lang.String;@30b8a058
        System.out.println(parser.parseExpression("{'java','c语言','PHP'}").getValue()); //[java, c语言, PHP] 创建List

        System.out.println(parser.parseExpression("new spring.springboot2.Test1.WorkeService().run()").getValue());

    }
}
