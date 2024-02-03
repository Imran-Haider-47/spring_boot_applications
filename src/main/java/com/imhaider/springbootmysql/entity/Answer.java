package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

@Data
@Table(name="answer")
@Entity
@Builder
public class Answer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String content;

    private boolean isCorrect = false;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructors, getters, and setters
}