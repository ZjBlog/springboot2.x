package spring.springboot2;

import org.junit.Test;
import spring.springboot2.entity.Color;
import spring.springboot2.entity.CouponType;

import java.lang.reflect.Field;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/15 16:39
 */
public class TestEnum {

    @Test
    public void test() throws NoSuchFieldException, IllegalAccessException {

        Class aClass = CouponType.class;


        Object[] objects = aClass.getEnumConstants();
        for (Object object : objects) {
            System.out.println(object.toString());
        }


        /**
         *  仅能获取类本身的 private属性成员
         */
        Field field = aClass.getDeclaredField("type");
        Field nameField = aClass.getDeclaredField("name");

        field.setAccessible(true);
        nameField.setAccessible(true);

        /**
         * 仅能获取类(及其父类可以自己测试) public属性成员
         */
        //aClass.getField("type");



        System.out.println("=====================");
        for (Object o : objects) {
            //获取属性
            Object o1 = field.get(o);
            if (o1.equals("1024")) {
                nameField.get(o);
                System.out.println(nameField.get(o).toString());
            }

        }
        System.out.println("=====================");
        CouponType[] values = CouponType.values();
        for (CouponType value : values) {
            System.out.println(value);
        }

    }
}
