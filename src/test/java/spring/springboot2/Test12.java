package spring.springboot2;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author : ZJ
 * @date : 19-8-26 下午12:54
 */
public class Test12 {

    private static final int THREADS_CONUT = 5;
    public static volatile int count = 0;

    public static AtomicInteger count1 = new AtomicInteger(0);

    public static void increase() {
        count++;
        count1.incrementAndGet();
    }

    public static void main(String[] args) {


   //     ExecutorService executorService= Executors.newFixedThreadPool(10);
//
//        ThreadPoolExecutor executor=new ThreadPoolExecutor(10,10,1000, TimeUnit.SECONDS,new ArrayBlockingQueue<>(100));
//
//
//        for(Integer i=0;i<100;i++){
//        executor.execute(()-> increase());
//        }
//        System.out.println(count);
//        System.out.println(count1);
//        executor.shutdown();

        for (int i = 0; i < THREADS_CONUT; i++) {
            new Thread(() -> {
                for (int i1 = 0; i1 < 10; i1++) {
                    increase();
                }
            }).start();
        }

        while (Thread.activeCount() > 5) {
            Thread.yield();
        }
        System.out.println(count);
        System.out.println(count1);

    }

}
