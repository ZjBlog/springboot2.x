package spring.springboot2.x;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring.springboot2.x.service.TestService;
import spring.springboot2.x.until.KeyWorker;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Slf4j
@SpringBootTest
@ActiveProfiles(value = "test")
public class ApplicationTests {


    @Autowired
    private TestService testService;


    @Test
    public void contextLoads() {
        log.info("test");
    }

    @Test
    public void testLevel() {
        log.info("log level is debug :{}", log.isDebugEnabled());
    }


    @Test
    public void testService() {
        long l = KeyWorker.nextId();
        System.out.println(l);
    }


    @Test
    public void test1() throws ParseException {
        SimpleDateFormat format1 = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss");
        LocalDate localDate = LocalDate.now();
        String time = localDate.toString() + " " + "16:30:00";
        Date parse = format1.parse(time);
        System.out.println(parse);
    }

    @Test
    public void testService1() {

        String str = "ddd_";
        String[] s = StringUtils.split(str, "_");
        log.info("====" + s.length);
    }

    @Test
    public void testBig() {

        BigDecimal multiply = BigDecimal.valueOf(10000.12).multiply(BigDecimal.valueOf(0.99)).setScale(2, BigDecimal.ROUND_HALF_UP);
        System.out.println(multiply.toString());

        BigDecimal subtract = BigDecimal.valueOf(1).subtract(BigDecimal.valueOf(0.98));
        System.out.println(subtract);
    }


}
