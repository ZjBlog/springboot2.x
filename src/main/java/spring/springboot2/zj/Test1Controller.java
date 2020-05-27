package spring.springboot2.zj;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.springboot2.entity.OrderInfo;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2020/5/27 14:35
 */
@RestController
public class Test1Controller {


    @GetMapping("/t1")
    public OrderInfo HellorWorld1() {
        OrderInfo orderInfo = new OrderInfo();
        orderInfo.setCreateTime(LocalDateTime.now());
        orderInfo.setUpdateTime(new Date());
        return orderInfo;
    }
}
