package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/7/21 20:50
 * @Description
 */
@Slf4j
@Service
public class ProductService {


    public String get(String key) {
        log.info("=======================:" + key);
        return key;
    }
}
