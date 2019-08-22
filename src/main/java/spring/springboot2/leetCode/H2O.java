package spring.springboot2.leetCode;

import java.util.concurrent.Semaphore;

/**
 * @author : ZJ
 * @date : 19-8-22 下午4:04
 */

/**
 * 1、Semaphore信号量作为一种流控手段，可以对特定资源的允许同时访问的操作数量进行控制，
 * 例如池化技术(连接池)中的并发数，有界阻塞容器的容量等。
 *
 * 2、Semaphore中包含初始化时固定个数的许可，在进行操作的时候，
 * 需要先acquire获取到许可，才可以继续执行任务，如果获取失败
 * ，则进入阻塞；处理完成之后需要release释放许可。
 *
 * 3、acquire与release之间的关系：在实现中不包含真正的许可对象，
 * 并且Semaphore也不会将许可与线程关联起来，因此在一个线程中
 * 获得的许可可以在另一个线程中释放。可以将acquire操作视为是消费一个许可，
 * 而release操作是创建一个许可，Semaphore并不受限于它在创建时的初始许可数量。
 * 也就是说acquire与release并没有强制的一对一关系，release一次就相当于新增一个许可，
 * 许可的数量可能会由于没有与acquire操作一对一而导致超出初始化时设置的许可个数。
 */
public class H2O {
    Semaphore oxygen = new Semaphore(2);
    Semaphore hydrogen = new Semaphore(0);

    public H2O() {

    }

    public void hydrogen() throws InterruptedException {
        hydrogen.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        System.out.println("h");
        oxygen.release();
    }

    public void oxygen() throws InterruptedException {
        oxygen.acquire(2);
        // releaseOxygen.run() outputs "H". Do not change or remove this line.
        System.out.println("0");
        hydrogen.release(2);
    }
}
