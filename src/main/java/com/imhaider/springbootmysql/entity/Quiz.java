package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.OffsetDateTime;
import java.util.HashSet;
import java.util.Set;


@Data
@Table(name="quiz")
@Entity
public class Quiz extends Identity{

    private String title;
    private OffsetDateTime attemptedAt;
    private OffsetDateTime submittedAt;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "quiz_question",
            joinColumns = @JoinColumn(name = "question_id"),
            inverseJoinColumns = @JoinColumn(name = "quiz_id"))
    private Set<Question> questions = new HashSet<>();


}
