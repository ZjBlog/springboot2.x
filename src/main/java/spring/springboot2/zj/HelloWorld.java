package spring.springboot2.zj;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class HelloWorld {

    @GetMapping("/")
    public  String HellorWorld(){
        return  "Hello World Spring boot2.x";
    }
}
