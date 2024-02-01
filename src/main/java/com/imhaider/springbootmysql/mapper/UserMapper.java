package com.imhaider.springbootmysql.mapper;

import com.imhaider.springbootmysql.dto.UserDTO;
import com.imhaider.springbootmysql.entity.User;

public class UserMapper {
    public  static UserDTO toDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        return  userDto;
    }
    
}
