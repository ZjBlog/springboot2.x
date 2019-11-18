package spring.springboot2.zj;


import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.threads.ThreadPoolExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.repository.RoleBotRepository;

import java.util.Optional;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@RestController
public class HelloWorld {


    @Autowired
    private RoleBotRepository roleBotRepository;

    @GetMapping("/")
    public String HellorWorld() {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        ExecutorService executorService = new ThreadPoolExecutor(1000, 10000, 10, TimeUnit.SECONDS, new ArrayBlockingQueue(200));


        for (Integer i = 0; i < 500; i++) {
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
        return "ok";
    }


}
