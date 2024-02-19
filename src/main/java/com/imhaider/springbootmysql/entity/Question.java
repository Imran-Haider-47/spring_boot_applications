package com.imhaider.springbootmysql.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Table(name = "question")
@Entity
public class Question extends Identity {

    private String content;

    @ManyToMany(mappedBy = "questions")
    private Set<Quiz> quizzes = new HashSet<>();

    @JsonIgnore
    @ToString.Exclude
    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Answer> answers = new ArrayList<>();

    // Constructors, getters, and setters
}
