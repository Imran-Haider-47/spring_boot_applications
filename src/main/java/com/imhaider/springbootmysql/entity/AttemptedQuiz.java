package com.imhaider.springbootmysql.entity;

import jakarta.persistence.*;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attempted_quiz")
@Entity
public class AttemptedQuiz extends Identity{

    @ManyToOne
    @JoinColumn(name="attempt_id")
    private Attempt attempt;

    @ManyToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "question_id")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "answer_id")
    private Answer answer;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;


}
