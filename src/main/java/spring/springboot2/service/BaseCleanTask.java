package spring.springboot2.service;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/12 13:56
 */
public abstract class BaseCleanTask {

    private static final Logger log = LoggerFactory.getLogger(BaseCleanTask.class);

    /**
     * 线程池
     */
    private ExecutorService executor;


    @Autowired
    private WorkService workService;

    /**
     * 初始话线程池
     * ①ArrayBlockingQueue
     * <p>
     * 基于数组的有界阻塞队列，按FIFO排序。新任务进来后，会放到该队列的队尾，有界的数组可以防止资源耗尽问题。
     * 当线程池中线程数量达到corePoolSize
     * 后，再有新任务进来，则会将任务放入该队列的队尾，等待被调度。如果队列已经是满的，则创建一个新线程，
     * 如果线程数量已经达到maxPoolSize，则会执行拒绝策略。
     * <p>
     * ②LinkedBlockingQuene
     * <p>
     * 基于链表的无界阻塞队列（其实最大容量为Interger.MAX），按照FIFO排序。由于该队列的近似无界性，
     * 当线程池中线程数量达到corePoolSize
     * 后，再有新任务进来，会一直存入该队列，而不会去创建新线程直到maxPoolSize，
     * 因此使用该工作队列时，参数maxPoolSize其实是不起作用的。
     * <p>
     * ③SynchronousQuene
     * <p>
     * 一个不缓存任务的阻塞队列，生产者放入一个任务必须等到消费者取出这个任务。
     * 也就是说新任务进来时，不会缓存，而是直接被调度执行该任务，如果没有可用线程，则创建新线程，如果线程数量达到maxPoolSize，则执行拒绝策略。
     * <p>
     * ④PriorityBlockingQueue
     * <p>
     * 具有优先级的无界阻塞队列，优先级通过参数Comparator实现。
     *
     * @param coreSize 核心线程数
     */
    protected void init(Integer coreSize) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("clean-" + getKey() + "104-pool" +
                "-%d"
        ).build();
        //SynchronousQuene
        executor = new ThreadPoolExecutor(
                0,
                coreSize,
                1L,
                TimeUnit.HOURS,
                new LinkedBlockingQueue<>(2),
                namedThreadFactory,
                new ThreadPoolExecutor.DiscardPolicy());
        log.info("清洗数据类型{}104线程池已创建", this.getKey());
    }

    /**
     * 查询待处理数据类型
     */
    protected abstract String getKey();

    /**
     * 获取待清洗的数据
     *
     * @return
     */
    protected List<Integer> getList() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
        return list;
    }

    /**
     * 清洗任务
     *
     * @param size 线程最大处理数
     */
    protected void clean(Integer size) {
        log.info("clean start!");
        executor.execute(() -> {
            List<Integer> list = getList();
            Integer everyMaxNum = size;
            if (everyMaxNum == null || everyMaxNum <= 0) {
                everyMaxNum = 200;
            }
            List<List<Integer>> partition = Lists.partition(list, everyMaxNum);
            List<Future> futureList = new ArrayList<>(list.size());
            Future submit = null;
            for (List<Integer> scfSourceData : partition) {
                submit = executor.submit(() -> scfSourceData.forEach(data -> {
                    try {
                        workService.work(data);
                    } catch (Exception e) {
                        log.error("clean data error!id is.", e);
                    }
                }));
                futureList.add(submit);
            }
            // 循环遍历futrues
            futureList.forEach(future -> {
                try {
                    future.get();
                } catch (Exception e) {
                    log.error("future get error!", e);
                }
            });
        });

    }
}
