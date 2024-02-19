package com.imhaider.springbootmysql.dto.quiz;

import com.imhaider.springbootmysql.dto.AttemptedQuestionRequest;
import lombok.Value;

import java.util.List;


@Value
public class AttemptQuizRequest {

    Long quizId;
    List<AttemptedQuestionRequest> attemptedQuestions;

}

