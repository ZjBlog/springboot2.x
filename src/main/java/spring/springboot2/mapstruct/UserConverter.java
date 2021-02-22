package spring.springboot2.mapstruct;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * @author zhangjun486
 * @version 1.0
 * @date 2021/1/13 18:32
 * @Description
 */
@Mapper
public interface UserConverter {
    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    @Mappings({@Mapping(source = "sex", target = "gender"), @Mapping(source = "test", target = "test1")})
    UserDTO converterDo(UserDO userDO);
}
