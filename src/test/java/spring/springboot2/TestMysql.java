package spring.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.entity.User;
import spring.springboot2.mapper.UserBotMapper;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/18 14:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-mybatis.properties")
@Slf4j
public class TestMysql {

    @Autowired
    private UserBotMapper userBotMapper;

    @Test
    public void test() {
        RoleBot byId = userBotMapper.getById(1);
        log.info(byId.toString());
    }

    @Test
    public void test1() {
        RoleBot roleBot=new RoleBot();
        roleBot.setUser(9);
        roleBot.setName("张三");
        roleBot.setUserName("zhangsan");
        int save = userBotMapper.save(roleBot);
        log.info("id:"+save);
        log.info(roleBot.getId()+"");
    }


    @Test
    public void test2() {
        RoleBot roleBot=new RoleBot();
        roleBot.setUser(9);
        roleBot.setName("张三");
        roleBot.setUserName("zhangsan");
        int save = userBotMapper.save1(roleBot);
        log.info("id:"+save);
        log.info(roleBot.getId()+"");
    }

    @Test
    public void test3() {
        User user=new User();
        user.setName("d");
        user.setUserId(11);
        user.setAge(11);

        int s=userBotMapper.save2(user);
        log.info("info#{}",s);
        log.info(user.toString());
    }
}
