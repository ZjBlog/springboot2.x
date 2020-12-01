package spring.springboot2.zj;

import java.lang.reflect.Field;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import spring.springboot2.Until.SpringContextUtil;
import spring.springboot2.entity.TetsDto;
import spring.springboot2.service.Say;
import spring.springboot2.service.SayHelloWorldWrapper;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:08
 * @Description
 */
@RestController
public class TestController {

    @Autowired
    private Say say;

    @GetMapping("/test9")
    public String HellorWorld2() {
        Map<String, Say> beansOfType1 = SpringContextUtil.getBeansOfType(Say.class);
        System.out.println(beansOfType1);
        return "ok";
    }

    @GetMapping("/test10")
    public String HellorWorld3() {
        SayHelloWorldWrapper bean = SpringContextUtil.getBean(SayHelloWorldWrapper.class);
        System.out.println(bean.sayHello());
        return "ok";
    }

    @GetMapping("/test11")
    public String HellorWorld31() {
        // WrapUtil.getRealBeanOfType(Say.class).sayHello();
        say.sayHello();
        return "ok";
    }

    @PostMapping("/test/json")
    public String testJson(@RequestBody TetsDto tetsDto) {

        Class<? extends TetsDto> aClass = tetsDto.getClass();
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            System.out.println(declaredField.getName());
        }
        System.out.println(tetsDto.getName());
        return "ok";
    }
}
