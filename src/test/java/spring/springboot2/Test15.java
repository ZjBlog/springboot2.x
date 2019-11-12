package spring.springboot2;

import org.hibernate.validator.constraints.br.TituloEleitoral;
import org.junit.Test;
import spring.springboot2.entity.Student;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test15 {


    public static void main1(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // 栈后进先出
        //向栈内压入一个成员
        stack.push(12);
        stack.push(13);
        stack.push(14);
        System.out.println(stack);

        //取出栈顶元素，不删除 null 报错
        Integer peek = stack.peek();
        System.out.println(peek);
        //取出栈顶元素并删除 null 报错
        Integer pop = stack.pop();
        System.out.println(pop);


        System.out.println(stack);

    }

    //  @Test
    public void test() {
        Queue<String> queue = new LinkedList<String>();
        queue.add("22");
        queue.offer("44");

        queue.remove();

        queue.remove();

        String element1 = queue.peek();
        System.out.println(element1);

        System.out.println(queue);
    }

    // @Test
    public void test2() {
        Integer flag = 0;

        flag = flag | 0;
        flag = flag | 2;
        flag = flag | 0;
        System.out.println(flag);
        String s = Integer.toBinaryString(flag);
        System.out.println(s);

    }

    //  @Test
    public void test3() {
//
//        Student a =new Student();
//        Student b=a;
//
//        System.out.println( a.equals(b));

        int a1 = 200;
        Integer a2 = new Integer(200);
        Integer a3 = new Integer(200);
        System.out.println(a3 == a2);
        System.out.println(a3.equals(a2));
        System.out.println(a2 == a1);
        System.out.println(a1 == a2);


    }

    /**
     * 这些类都有缓存的范围，其中Byte，Short，Integer，Long为 -128 到 127，Character范围为 0 到 127。
     * IntegerCache
     * 该类的作用是将数值等于-128-127(默认)区间的Integer实例缓存到cache数组中。
     * 通过valueOf()方法很明显发现，当再次创建值在-128-127区间的Integer实例时，会复用缓存中的实例，
     * 也就是直接指向缓存中的Integer实例。
     * (注意：这里的创建不包括用new创建，
     * new创建对象不会复用缓存实例，通过情景3的运行结果就可以得知)
     */
    //@Test
    public void test4() {

        Integer a = 1;
        Integer b = 1;
        System.out.println(a == b);//true

        Integer c = 128;
        Integer d = 128;
        System.out.println(c == d);//false 超过127 会new

        Integer e = new Integer(1);
        Integer f = new Integer(1);
        System.out.println(e == f);//false
    }

    /**
     * a是基本类型，b和c是引用类型，两者进行比较时有一个拆箱的过程，也就是会默认调用b和c的intValue()方法
     * 包装类和基本类型比较时，包装类自动拆箱为基本类型
     */
    @Test
    public void test5() {
        int a = 128;
        //装箱
        Integer b = Integer.valueOf(128);
        // 拆箱
        int d=b.intValue();
        Integer c = new Integer(128);

        System.out.println(b==a);//true
        System.out.println(a == c);//true
        System.out.println(b == c);//false
        Integer i7  = 127;
        Integer i8  = 127;
        System.out.println(i7==i8);//true
        System.out.println(i7.equals(i8));//true
    }

    @Test
    public void test6() {
        System.out.println( (250*3/16 + 1) *16 /3 * 4);
    }
}
