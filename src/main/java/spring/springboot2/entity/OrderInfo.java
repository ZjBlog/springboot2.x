package spring.springboot2.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @author zj
 * @version 1.0
 * @date 2020/5/27 14:14
 */
@Data
public class OrderInfo {

    private LocalDateTime createTime;


    //覆盖全局时间格式化配置
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;
}
