package spring.springboot2;

import org.junit.Test;

import java.util.concurrent.Semaphore;

/**
 * @author : ZJ
 * @date : 19-8-22 下午5:03
 */
public class Test11 {

    //@Test
    public void test() {
        Semaphore semaphore = new Semaphore(5);

        for (int i = 0; i < 20; i++) {
            final int j = i;
            new Thread(() -> {
                try {
                    semaphore.acquire(2);
                    System.out.println("i" + j);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }).start();


        }
    }

    @Test
    public void test1() {
      System.out.println(0%2);
    }
}
