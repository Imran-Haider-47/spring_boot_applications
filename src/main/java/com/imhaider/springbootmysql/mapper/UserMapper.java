package com.imhaider.springbootmysql.mapper;

import com.imhaider.springbootmysql.dto.user.UserDTO;
import com.imhaider.springbootmysql.entity.User;

import java.util.List;

public class UserMapper {
    public  static UserDTO toDto(User user){
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        return  userDto;
    }
    public static List<UserDTO> toDto(List<User> users){
        return users.stream().map(UserMapper::toDto).toList();
    }
    
}
