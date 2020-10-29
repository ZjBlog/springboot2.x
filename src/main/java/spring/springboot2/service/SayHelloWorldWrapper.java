package spring.springboot2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Conditional;
import org.springframework.stereotype.Service;
import spring.springboot2.wrap.WrapCondition;
import spring.springboot2.wrap.WrapMethodHelper;
import spring.springboot2.wrap.WrapService;
import spring.springboot2.wrap.WrapTemplate;
import spring.springboot2.wrap.WrapUtil;
import spring.springboot2.wrap.Wrapper;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/10/29 20:35
 * @Description
 */
@Service
//它的作用是按照一定的条件进行判断，满足条件给容器注册bean
//满足条件才注册
@Conditional(WrapCondition.class)
@Wrapper(switchProperty = "wrap.say")
public class SayHelloWorldWrapper implements Say {
    @Autowired
    private WrapService wrapService;

    @Override
    public String sayHello() {

        return WrapMethodHelper.invoke("sayHello", "say", wrapService, new WrapTemplate() {
            @Override
            public Object callReal() {
                return WrapUtil.getRealBeanOfType(Say.class).sayHello();
            }

            @Override
            public Object matchByCode() {
                return "ok";
            }
        });
    }
}
