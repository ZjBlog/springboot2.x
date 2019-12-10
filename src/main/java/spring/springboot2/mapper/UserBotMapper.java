package spring.springboot2.mapper;

import org.apache.ibatis.annotations.*;
import spring.springboot2.entity.RoleBot;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2019/11/18 17:36
 */
//@CacheNamespace
@Mapper
public interface UserBotMapper {

    @Select("select id, name,user,user_name from role_bot where id=#{id}")
    RoleBot getById(Integer id);

    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id")
    @Insert("INSERT INTO role_bot(`name`,`user`,`user_name`) VALUES(#{name},#{user},#{userName})")
    int save(RoleBot roleBot);

    @SelectKey(statement="select last_insert_id()",before=false,keyProperty="id",resultType=Integer.class,keyColumn="id")
    @Insert("INSERT INTO role_bot(`name`,`user`,`user_name`) VALUES(#{name},#{user},#{userName})")
    int save1(RoleBot roleBot);

    @SelectKey(keyProperty = "id", resultType = String.class, before = true,
            statement = "select replace(uuid(), '-', '') as id from dual")
    @Insert("INSERT INTO role_bot(`name`,`user`,`user_name`) VALUES(#{name},#{user},#{userName})")
    int save2(RoleBot roleBot);
}
