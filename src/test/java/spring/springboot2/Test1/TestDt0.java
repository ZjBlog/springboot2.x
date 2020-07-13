package spring.springboot2.Test1;

import spring.springboot2.Until.JavaxValidator;
import spring.springboot2.entity.TetsDto;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/13 11:16
 * @Description
 */
public class TestDt0 {

    public static void main(String[] args) {
        TetsDto tetsDto = new TetsDto();
        tetsDto.setCompanyType_type("789999");
        String validate = JavaxValidator.validate(tetsDto);
        System.out.println(validate);
    }
}
