package spring.springboot2.Test1;

import spring.springboot2.entity.ErrorResult;
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
        //@Accessors(chain = true)链式调用
        ErrorResult.error().setCode("d").setCode("");
    }
}
