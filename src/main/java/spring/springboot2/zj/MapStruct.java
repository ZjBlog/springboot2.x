package spring.springboot2.zj;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;

import spring.springboot2.mapstruct.UserConverter;
import spring.springboot2.mapstruct.UserDO;
import spring.springboot2.mapstruct.UserDTO;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/1/13 18:42
 * @Description
 */
@RestController
public class MapStruct {

    @RequestMapping("/mapstruct")
    public String test() {
        UserDO userDO = new UserDO();
        userDO.setSex(1);
        userDO.setTest("test");

        UserDTO userDTO = UserConverter.INSTANCE.converterDo(userDO);
        System.out.println(JSON.toJSONString(userDTO));
        return "ok";
    }
}
