package com.imhaider.springbootmysql.dto.user;

import com.imhaider.springbootmysql.entity.User;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
@Data
public class UserDTO {

    private Long id;
    private String name;
    private int age;
    private String email;

    public  static UserDTO of(User user){
        UserDTO userDto = new UserDTO();
        userDto.setId(user.getId());
        userDto.setName(user.getName());
        userDto.setAge(user.getAge());
        userDto.setEmail(user.getEmail());
        return  userDto;
    }
    public static List<UserDTO> of(List<User> users){
        return users.stream().map(UserDTO::of).toList();
    }

}
