package spring.springboot2.x.zj;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

    @Value("${name}")
    private String testname;

    @Value("${importName}")
    private String name;

    @GetMapping("/")
    public String HellorWorld() {
        return "Hello World Spring boot2.x" + testname + ":==:" + name;
    }
}
