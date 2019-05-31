package spring.springboot2.zj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.exercise.zeren.ZeRenService;
import spring.springboot2.service.RabbitSender;
import spring.springboot2.service.RabbitSender1;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {


    @Autowired
    private RabbitSender rabbitSender;

    @Autowired
    private RabbitSender1 rabbitSender1;

    @Autowired
    private ZeRenService zeRenService;



    @GetMapping("/test1")
    public String test1(){
        rabbitSender1.sendMsg("ddd");
        return "ok";
    }



    @GetMapping("/test")
    public String test(){
      //  zeRenService.mockedClient();
        zeRenService.cal("duration");
        return "ok";
    }
}
