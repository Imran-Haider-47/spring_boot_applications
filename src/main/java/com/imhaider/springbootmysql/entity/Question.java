package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Data
@Table(name="question")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    @ManyToMany(mappedBy = "questions")
    private Set<Quiz> quizzes = new HashSet<>();

    @OneToMany(mappedBy = "question")
    private List<Answer> answers;
}