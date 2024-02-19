package com.imhaider.springbootmysql.dto.quiz;

import com.imhaider.springbootmysql.dto.question.CreateQuestionResponse;
import com.imhaider.springbootmysql.entity.Quiz;
import lombok.Builder;
import lombok.Value;

import java.util.Set;

@Value
@Builder
public class CreateQuizResponse {
    long id;
    String title;
    Set<CreateQuestionResponse> questions;
    public static CreateQuizResponse of(final Quiz quiz) {
        return CreateQuizResponse.builder()
                .id(quiz.getId())
                .title(quiz.getTitle())
                .questions(CreateQuestionResponse.of(quiz.getQuestions()))
                .build();
    }

}