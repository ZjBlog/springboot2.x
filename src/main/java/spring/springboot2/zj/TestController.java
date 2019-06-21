package spring.springboot2.zj;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.Color;
import spring.springboot2.entity.UserBot;
import spring.springboot2.exercise.zeren.ZeRenService;
import spring.springboot2.repository.UserBotRepository;
import spring.springboot2.service.RabbitSender;
import spring.springboot2.service.RabbitSender1;
import spring.springboot2.service.TransactionalService;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {


    @Autowired
    private RabbitSender1 rabbitSender1;

    @Autowired
    private RabbitSender rabbitSender;

    @Autowired
    private ZeRenService zeRenService;

    @Autowired
    private UserBotRepository userBotRepository;

    @Autowired
    private TransactionalService transactionalService;


    @GetMapping("/test1")
    public String test1() {
        UserBot userBot = new UserBot();
        userBot.setId(1);
        userBot.setReadIs("dddd");
        rabbitSender1.sendMsg(userBot);
        rabbitSender.sendMsg("test");
        return "ok";
    }

    @GetMapping("/test")
    public String test() {
        zeRenService.cal("duration");
        return "ok";
    }

    @GetMapping("/test2")
    public Object test2() {
        return userBotRepository.findAll();
    }

    @GetMapping("/test3")
    public Object test3() {
        UserBot userBot = new UserBot();
        userBot.setReadIs("dddd");
        userBot.setColor(Color.BLUE);
        userBot=userBotRepository.save(userBot);
        return userBot;
    }

    @GetMapping("/test4")
    public Object test4() {
        try {
            transactionalService.testSysConfig2();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ok";
    }
}
