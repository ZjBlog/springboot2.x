package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/12 16:08
 */
@Service
@Slf4j
public class TaskOne extends BaseCleanTask {


    // @PostConstruct
    public void execute() {
        init(10);
        clean(200);
    }

    @Override
    protected String getKey() {
        return "one";
    }
}
