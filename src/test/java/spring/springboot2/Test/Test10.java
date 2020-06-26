package spring.springboot2.Test;

import org.junit.Test;
import spring.springboot2.entity.Student;
import spring.springboot2.leetCode.FooBar;
import spring.springboot2.leetCode.H2O;
import spring.springboot2.leetCode.ZeroEvenOdd;
import spring.springboot2.leetCode.ZeroEvenOdd1;

public class Test10 {


    @Test
    public void test2() throws InterruptedException {


        H2O h2O=new H2O();

        new Thread(()->{
            try {
                h2O.hydrogen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(()->{
            try {
                h2O.oxygen();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

//        ZeroEvenOdd1 zeroEvenOdd=new ZeroEvenOdd1(10);
//
//        new Thread(()->{
//            try {
//                zeroEvenOdd.zero();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        new Thread(()->{
//            try {
//                zeroEvenOdd.odd();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();

//        new Thread(()->{
//            try {
//                zeroEvenOdd.even();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }).start();
//
//        FooBar fooBar=new FooBar(10);
//
//        new Thread(()->{
//            fooBar.foo();
//        }).start();
//
//        new Thread(()->{
//            fooBar.bar();
//        }).start();

    }

   // @Test
    public void test(){

        Student stu1 = new Student();
        stu1.setName("499");
        Student stu2 = (Student)stu1.clone();

        System.out.println("学生1:" + stu1.getName());
        System.out.println("学生2:" + stu2.getName());

        stu2.setName("=====");

        System.out.println("学生1:" + stu1.getName());
        System.out.println("学生2:" + stu2.getName());
    }
}
