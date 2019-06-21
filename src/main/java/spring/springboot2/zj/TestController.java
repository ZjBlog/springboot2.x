package spring.springboot2.zj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.exercise.zeren.ZeRenService;
import spring.springboot2.service.RabbitSender1;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {


    @Autowired
    private RabbitSender1 rabbitSender1;

    @Autowired
    private ZeRenService zeRenService;


    @GetMapping("/test1")
    public String test1() {
        rabbitSender1.sendMsg("ddddd");
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        zeRenService.cal("duration");
        return "ok";
    }
}
