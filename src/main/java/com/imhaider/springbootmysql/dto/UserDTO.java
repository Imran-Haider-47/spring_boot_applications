package com.imhaider.springbootmysql.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
public class UserDTO {

    private Integer id;
    private String name;
    private int age;
    private String email;

}
