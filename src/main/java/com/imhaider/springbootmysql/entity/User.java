package com.imhaider.springbootmysql.entity;
import com.imhaider.springbootmysql.enums.Role;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private int age;
    private String password;
    private String email;

    @Enumerated(EnumType.STRING)
    private Role role;
}

