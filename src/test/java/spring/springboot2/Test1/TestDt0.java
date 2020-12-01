package spring.springboot2.Test1;

import java.util.List;

import spring.springboot2.Until.JavaxValidator;
import spring.springboot2.entity.TestDto2;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/13 11:16
 * @Description
 */
public class TestDt0 {

    public static void main(String[] args) {
        TestDto2 testDto2 = new TestDto2();
        // testDto2.setCompanyType("ttt");
        testDto2.setName("888");
        List<String> list = JavaxValidator.invalidValueMsg(testDto2);
        System.out.println(list);

    }
}
