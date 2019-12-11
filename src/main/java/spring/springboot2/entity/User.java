package spring.springboot2.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * @author : ZJ
 * @date : 19-6-21 下午12:51
 */

@Data
public class User implements Serializable {


    private String id;


    private String name;

    private Integer userId;

    private Integer age;

}
