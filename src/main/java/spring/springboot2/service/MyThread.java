package spring.springboot2.service;

import lombok.AllArgsConstructor;

import javax.annotation.PostConstruct;
import java.util.concurrent.CountDownLatch;

/**
 * @author : ZJ
 * @date : 19-8-21 下午1:55
 */
@AllArgsConstructor
public class MyThread extends Thread {
    private MyService service;
    private final CountDownLatch begin;
    private final CountDownLatch end;

    @Override
    public void run() {
        try {
            begin.await();//每个参赛选手都站在自己的跑道上，做好了比赛的准备，正在等裁判鸣枪开始比赛
            service.testMethod();//听到鸣枪后比赛开始了
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            end.countDown();//其中的一个参赛选手已经跑完了
        }

    }

}
