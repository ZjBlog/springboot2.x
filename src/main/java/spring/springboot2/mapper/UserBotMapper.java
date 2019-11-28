package spring.springboot2.mapper;

import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
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
    public RoleBot getById(Integer id);
}
