package spring.springboot2.zj;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestController
public class HelloWorld {


    @Value(value = "${username}")
    private String name;
    @GetMapping("/")
    public  String HellorWorld(){
        return  "Hello World 1Spring boot2.x for" + name;
    }
}
