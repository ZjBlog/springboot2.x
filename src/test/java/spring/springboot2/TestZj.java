package spring.springboot2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/10/30 9:14
 */
//@RunWith(SpringRunner.class)
//@SpringBootTest
public class TestZj {

    @Test
    public void contextLoads() {
        int totalSecs = 12000;
        int hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        String timeString = "";
        if (hours > 0) {
            timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        } else {
            timeString = String.format("%02d:%02d", minutes, seconds);
        }
        System.out.println(timeString);
        System.out.println("===========================");
    }
}
