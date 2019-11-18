package spring.springboot2;

import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.repository.RoleBotRepository;

import java.awt.*;
import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/18 14:01
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource("classpath:application-mysql.properties")
@Slf4j
public class TestMysql {

    @Autowired
    private RoleBotRepository roleBotRepository;

    @Test
    public void test() {
        RoleBot roleBot = new RoleBot();
        roleBot.setName("hehe");
        roleBot.setUser(0);
        roleBotRepository.save(roleBot);
        log.info("==========");
    }

    ;

    @Test
    public void tes1() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executorService = new ThreadPoolExecutor(5, 10000, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(200));


        for (Integer i = 0; i < 10; i++) {
            executorService.execute(
                    () -> {
                        try {
                            log.info("=======");
                            countDownLatch.await();
                            Optional<RoleBot> byId = roleBotRepository.findById(1);
                            log.info("查询结果" + byId.get().toString());
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
            );
        }
        countDownLatch.countDown();
        log.info("开始====查询");

    }
}
