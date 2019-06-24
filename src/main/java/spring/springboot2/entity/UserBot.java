package spring.springboot2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : ZJ
 * @date : 19-6-21 下午12:51
 */
@Entity
@Data
public class UserBot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    /**
     * 映射数据库中的字段 一般用在字段使用了数据库的关键字的时候
     */
    @Column(name = "`read`")
    private String readIs;
    /**
     * @Enumerated(EnumType.ORDINAL)
     * 把一个枚举类型 映射到数据库 城int类型
     * @Enumerated(EnumType.String)
     * 映射城String
     * 如果不加注解默认会使用enum 的ordinal 值存到数据库
     */
    /**
     * 加注解 会是一个RED字符串
     */
    @Enumerated(EnumType.STRING)
    private Color color;
}
