package spring.springboot2.zj;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.exercise.zeren.ZeRenService;

/**
 * @author : ZJ
 * @date : 18-10-15 下午2:00
 */
@RestController
public class TestController {
    @Autowired
    private ZeRenService zeRenService;

    @GetMapping("/test")
    public String test(){
      //  zeRenService.mockedClient();
        zeRenService.cal("duration");
        return "ok";
    }
}
