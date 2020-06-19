package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/12 13:59
 */
@Service
@Slf4j
public class WorkService {


    public void work(Integer work) {

        try {
            Thread.sleep(1000 * 2);
            log.info("耗时操作====:" + Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
