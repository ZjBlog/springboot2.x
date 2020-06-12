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
     *
     * @param coreSize 核心线程数
     */
    protected void init(Integer coreSize) {

        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("clean-" + getKey() + "104-pool" +
                "-%d"
        ).build();
        executor = new ThreadPoolExecutor(
                coreSize,
                10,
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
