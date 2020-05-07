package spring.springboot2.mapper;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;
import spring.springboot2.entity.RoleBot;
import spring.springboot2.entity.User;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/18 17:36
 */
//@CacheNamespace
@Mapper
@Component
public interface UserBotMapper {

    @Select("select id, name,user,user_name from role_bot where id=#{id}")
    RoleBot getById(Integer id);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("INSERT INTO role_bot(`name`,`user`,`user_name`) VALUES(#{name},#{user},#{userName})")
    int save(RoleBot roleBot);

    /**
     * 生成的id映射到实体中
     * @param roleBot
     * @return
     */
    @SelectKey(statement="select last_insert_id()",before=false,keyProperty="id",resultType=Integer.class,keyColumn="id")
    @Insert("INSERT INTO role_bot(`name`,`user`,`user_name`) VALUES(#{name},#{user},#{userName})")
    int save1(RoleBot roleBot);

    /**
     * uuid
     * @param user
     * @return
     */
    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert("INSERT INTO t_user(`id`,`user_id`,`name`,`age`) VALUES(#{id},#{userId},#{name},#{age})")
    int save2(User user);



    @Insert("INSERT INTO t_user(`id`,`user_id`,`name`,`age`) VALUES(#{id},#{userId},#{name},#{age})")
    int save3(User user);
}
