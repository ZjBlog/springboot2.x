package spring.springboot2.zj;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {


    @GetMapping("/")
    public String HellorWorld() {
        return "Hello World 1Spring boot2.x for";
    }


}
