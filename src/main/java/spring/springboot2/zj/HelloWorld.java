package spring.springboot2.zj;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import spring.springboot2.config.WxTest;

@RestController
public class HelloWorld {


    @Autowired
    private WxTest wxTest;

    @Value(value = "${username}")
    private String name;
    @GetMapping("/")
    public  String HellorWorld(){
        return  "Hello World 1Spring boot2.x for" + name+"==="+wxTest;
    }
}
