package spring.springboot2.x;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import spring.springboot2.x.service.TestService;
import spring.springboot2.x.until.KeyWorker;

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
}
