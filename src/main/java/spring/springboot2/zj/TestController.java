package spring.springboot2.zj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.Until.SpringContextUtil;
import spring.springboot2.service.Say;
import spring.springboot2.service.SayHelloWorldWrapper;

import java.util.Map;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:08
 * @Description
 */
@RestController
public class TestController {
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
}
