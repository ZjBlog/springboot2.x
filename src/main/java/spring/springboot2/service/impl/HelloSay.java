package spring.springboot2.service.impl;

import org.springframework.stereotype.Service;
import spring.springboot2.service.Say;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:11
 * @Description
 */
@Service
public class HelloSay implements Say {
    @Override
    public String sayHello() {
        System.out.println("Hello");
        return "hello";
    }
}
