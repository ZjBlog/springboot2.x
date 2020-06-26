package spring.springboot2.Test;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

/**
 * @author : ZJ
 * @date : 19-8-27 下午5:16
 */

/**
 * 随机数的种子
 */
public class Test13 {
    public static void main(String[] args) {
        Random random = new Random(50);
        System.out.println(random.nextInt(100));//总是17
        System.out.println(random.nextInt(100));//总是88
        Random random1 = new Random(50);
        System.out.println(random1.nextInt(100));//也总是17
        System.out.println(random1.nextInt(100));//也总是88
        new Random().ints(0, 5).limit(10).forEach(System.out::println);
        System.out.println(ThreadLocalRandom.current().nextInt(10)+"=");

    }
}
