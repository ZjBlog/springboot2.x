package spring.springboot2;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author : ZJ
 * @date : 19-8-20 下午3:39
 */
public class TaskWithResult implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println("call()方法被自动调用,干活！！！             " + Thread.currentThread().getName());
        Integer i = 0;
        for (int j = 0; j < 100; j++) {
            i += j;
        }
        return i;
    }
}
