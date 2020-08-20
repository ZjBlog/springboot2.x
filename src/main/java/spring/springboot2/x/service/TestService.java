package spring.springboot2.x.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import spring.springboot2.x.until.LoginUntil;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/8/17 17:16
 * @Description
 */
@Service
@Slf4j
public class TestService {

    public void test() {
        log.info("=======================" + LoginUntil.getPin());
    }
}
