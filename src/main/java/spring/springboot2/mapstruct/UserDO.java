package spring.springboot2.mapstruct;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/1/13 18:29
 * @Description
 */
@Data
public class UserDO {
    private Long id;
    private String username;
    private String password;
    private Integer sex;
    private LocalDate birthday;
    private LocalDateTime createTime;
    private String config;
    private String test;
}
