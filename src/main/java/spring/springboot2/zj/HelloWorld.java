package spring.springboot2.zj;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.mapper.UserBotMapper;

@Slf4j
@RestController
public class HelloWorld {


    @Autowired
    private UserBotMapper userBotMapper;

    @GetMapping("/")
    public String HellorWorld() {

        RoleBot byId = userBotMapper.getById(1);
        log.info("开始====查询"+byId.toString());
        return "ok";
    }


}
