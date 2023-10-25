package com.bread.coalquality.mvc.convert;


import com.bread.coalquality.mvc.dto.UserDTO;
import com.bread.coalquality.mvc.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
@Mapper
public interface  UserConvertMapper {

    UserConvertMapper INSTANCE = Mappers.getMapper(UserConvertMapper.class);

    /**
     * card 转 CardDto .
     *
     * @param card
     * @return
     */
    UserDTO dto(User card);

    /**
     * CardDt 转 card .
     *
     * @param cardDto
     * @return
     */
    User entity(UserDTO cardDto);


    public static void main(String[] args) {

        UserDTO dto = UserConvertMapper.INSTANCE.dto(User.builder().id(1L).passWord("1").userName("2").build());

        System.out.println(dto.toString());

        User entity = UserConvertMapper.INSTANCE.entity(dto);

        System.out.println(entity.toString());
    }

}
