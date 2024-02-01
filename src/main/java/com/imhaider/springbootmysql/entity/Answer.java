package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name="answer")
@Entity
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long answer_id;

    private String content;

    private boolean correct;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructors, getters, and setters
}