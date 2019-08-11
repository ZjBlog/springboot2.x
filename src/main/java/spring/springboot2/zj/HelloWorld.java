package spring.springboot2.zj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.springboot2.config.WxTest;
import spring.springboot2.service.ThymeleafService;

import javax.servlet.http.HttpServletResponse;

@RestController
public class HelloWorld {


    @Autowired
    private WxTest wxTest;


    @Autowired
    ThymeleafService thymeleafService;

    @Value(value = "${username}")
    private String name;


    @GetMapping("/")
    public String HellorWorld() {
        return "Hello World 1Spring boot2.x for" + name + "===" + wxTest;
    }


    @GetMapping("/test22")
    public void HellorWorld11( HttpServletResponse response) {
//http://www.glxxw2018.com/study/blog/detail/ag6Gf13MuC.html
        thymeleafService.createHtml(55L);

        response.setStatus(302);
        response.setHeader("Location", "http://www.baidu.com");
    }
}
