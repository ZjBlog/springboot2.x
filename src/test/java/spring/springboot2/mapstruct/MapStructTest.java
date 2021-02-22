package spring.springboot2.mapstruct;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.alibaba.fastjson.JSON;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/1/13 18:37
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest

public class MapStructTest {
    @Test
    public void test() {

        UserDO userDO = new UserDO();
        userDO.setSex(1);
        userDO.setTest("test");

        UserDTO userDTO = UserConverter.INSTANCE.converterDo(userDO);
        System.out.println(JSON.toJSONString(userDTO));

    }
}
