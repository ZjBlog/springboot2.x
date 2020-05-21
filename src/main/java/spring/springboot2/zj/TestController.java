package spring.springboot2.zj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.Reactor;
import reactor.event.Event;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/21 15:52
 */
@RestController
public class TestController {


    @Autowired
    Reactor reactor;
    @Autowired
    @Qualifier("reactor2")
    Reactor r2;

    @GetMapping("/tt")
    public String HellorWorld1() {
        reactor.notify("getUserMessage", Event.wrap("999999"));
        return "Hello World 1Spring boot2.x for";
    }

    @GetMapping("/tt22")
    public String HellorWorld3() {
        r2.notify("resultMessage", Event.wrap(20));
        return "Hello World 1Spring boot2.x for";
    }


    @GetMapping("/tt23")
    public String HellorWorld4() {
        r2.notify("event", Event.wrap(20));
        return "Hello World 1Spring boot2.x for";
    }
}
