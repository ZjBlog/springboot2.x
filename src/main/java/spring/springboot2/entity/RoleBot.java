package spring.springboot2.entity;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author : ZJ
 * @date : 19-7-1 上午11:43
 */
@Entity
@Data
public class RoleBot implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;


    /**
     * 可选属性optional=false,表示user_id不能为空。删除RoleBot，不影响用户
     */
//    @ManyToOne(optional = false,fetch = FetchType.LAZY)
//    @JoinColumn(name = "user_id")
    private Integer user;

}
