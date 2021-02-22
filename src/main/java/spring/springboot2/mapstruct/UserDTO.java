package spring.springboot2.mapstruct;

import java.time.LocalDate;

import lombok.Data;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/1/13 18:30
 * @Description
 */
@Data
public class UserDTO {
    private Long id;
    private String username;
    private String password;
    private Integer gender;
    private LocalDate birthday;
    private String createTime;
    private String test1; // 测试字段
}
