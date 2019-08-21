package spring.springboot2;

import org.junit.Test;
import spring.springboot2.entity.Student;

public class Test10 {

    @Test
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
