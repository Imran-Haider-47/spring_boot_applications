package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Table(name="quiz")
@Entity
public class Quiz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @OneToMany(mappedBy = "quiz", cascade = CascadeType.ALL)
    private List<Question> questions;

    // Constructors, getters, and setters
}
