package spring.springboot2;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author : ZJ
 * @date : 19-8-16 下午1:58
 */
public class Test6 {

    public static void main(String[] args) {
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        final CountDownLatch countDownLatch = new CountDownLatch(10);
        for (int i = 0; i < 10; i++) {
            final int currentIndex = i;
            cachedThreadPool.execute(() -> {

                try {
                    System.out.println(Thread.currentThread().getName() + ", currentIndex is : " + currentIndex);
                    Thread.sleep(1000*3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    countDownLatch.countDown();
                }
            });
        }
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("全部线程执行完毕");
    }
}
