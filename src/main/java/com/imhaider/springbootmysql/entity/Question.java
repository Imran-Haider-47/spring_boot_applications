package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Data
@Table(name="question")
@Entity
public class Question {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long question_id;

    private String content;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private List<Answer> answers;

    // Constructors, getters, and setters
}