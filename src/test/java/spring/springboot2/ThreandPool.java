package spring.springboot2;

import com.google.common.collect.Lists;
import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/6/11 18:13
 */
public class ThreandPool {

    public static void main1(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool" +
                "-%d"
        ).build();
        ExecutorService executor = new ThreadPoolExecutor(
                2,
                10,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                namedThreadFactory,
                new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }

        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "============");
            List<List<Integer>> partition = Lists.partition(list, 20);
            System.out.println("=====size:" + partition.size());
            List<Future<Integer>> list1 = new ArrayList<>();
            for (List<Integer> integers : partition) {
                Future<Integer> submit = executor.submit(() -> {
                            System.out.println(Thread.currentThread().getName() + "============");
                            Thread.sleep(1000 * 5);
                            return integers.stream().reduce(0, (a, b) -> a + b);
                        }
                );
                list1.add(submit);
            }

            AtomicInteger result = new AtomicInteger();

            list1.forEach(future -> {
                try {
                    Integer o = future.get();
                    result.addAndGet(o);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("============:" + result.get());
        });


    }

    public static void main(String[] args) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool" +
                "-%d"
        ).build();
        ExecutorService executor = new ThreadPoolExecutor(
                0,
                10,
                2L,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                namedThreadFactory,
                new ThreadPoolExecutor.DiscardPolicy());

        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < 1000000; i++) {
            list.add(i);
        }
        executor.execute(() -> {
            System.out.println(Thread.currentThread().getName() + "============");
            List<List<Integer>> partition = Lists.partition(list, 20);
            System.out.println("=====size:" + partition.size());
            List<Future> list1 = new ArrayList<>();
            for (List<Integer> integers : partition) {
                Future<?> submit = executor.submit(() -> {
                            System.out.println(Thread.currentThread().getName() + "============");
//                            integers.forEach(s -> {
//                                // System.out.println(Thread.currentThread().getName() + "============");
//                            });
                        }
                );
                list1.add(submit);
            }

            AtomicInteger result = new AtomicInteger();

            list1.forEach(future -> {
                try {
                    Object o = future.get();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (ExecutionException e) {
                    e.printStackTrace();
                }
            });
            System.out.println("============:" + result.get());
        });


    }
}
