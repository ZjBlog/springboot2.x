package spring.springboot2.x;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest
public class ApplicationTests {

	@Test
	public void contextLoads() {
        int totalSecs=12000;
        int  hours = totalSecs / 3600;
        int minutes = (totalSecs % 3600) / 60;
        int seconds = totalSecs % 60;
        String timeString="";
        if (hours>0) {
            timeString = String.format("%02d:%02d:%02d", hours, minutes, seconds);
        }else {
            timeString = String.format("%02d:%02d", minutes, seconds);
        }
        System.out.println(timeString);
	}


}
