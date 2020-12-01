package spring.springboot2.Test1;

import spring.springboot2.entity.TestEnum;

import java.lang.reflect.InvocationTargetException;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/30 16:14
 * @Description
 */
public class Test3 {

    public static void main2(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {

        Class<Enum> aClass = (Class<Enum>) Class.forName("spring.springboot2.entity.TestEnum");


        Enum[] enumConstants = aClass.getEnumConstants();


        for (Enum enumConstant : enumConstants) {

            String name = enumConstant.name();
            System.out.println(name);

        }
        System.out.println(enumConstants);


    }

    public static void main(String[] args) {
        TestEnum.valueOf("21");
    }
}
