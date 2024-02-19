package com.imhaider.springbootmysql.entity;

import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="answer")
@Builder
@Entity
public class Answer extends Identity{

    private String content;

    @Column(columnDefinition = "BOOLEAN DEFAULT false")
    private boolean isCorrect;

    @ManyToOne
    @JoinColumn(name = "question_id")
    private Question question;

    // Constructors (you can keep your explicit constructors here)
}
