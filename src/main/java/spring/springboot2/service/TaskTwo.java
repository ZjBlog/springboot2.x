package spring.springboot2.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;


/**
 * maxPoolSize  当线程数大于或等于核心线程，且任务队列已满时，线程池会创建新的线程，直到线程数量达到maxPoolSize。如果线程数已等于maxPoolSize
 * ，且任务队列已满，则已超出线程池的处理能力，线程池会拒绝处理任务而抛出异常。
 * <p>
 * 线程池任务队列 LinkedBlockingQueue 一定要有个固定大小
 * 1.如果无固定大小 会一直加任务 可能会oom
 * 2.任务队列不会满，会一直使用核心线程数
 */

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/12 16:11
 */
@Slf4j
@Service
public class TaskTwo extends BaseCleanTask {


    @PostConstruct
    public void execute() {
        init(0);
        clean(200);
    }

    @Override
    protected String getKey() {
        return "two";
    }
}
