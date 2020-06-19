package spring.springboot2.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.function.Predicate;

/**
 * @author : ZJ
 * @date : 19-6-21 下午12:51
 */

@Data
public class User implements Serializable {


    private static final long serialVersionUID = -6978203114843094910L;
    private String id;


    private String name;

    private Integer userId;

    private Integer age;


    public static Predicate<User> ageGreaterThan70 = x -> x.getAge() > 70;
}
