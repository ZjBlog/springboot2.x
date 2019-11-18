package spring.springboot2.zj;


import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class HelloWorld {



    @GetMapping("/")
    public String HellorWorld() {
        log.info("开始====查询");
        return "ok";
    }


}
