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
}
