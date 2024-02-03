package com.imhaider.springbootmysql.dto;

import com.imhaider.springbootmysql.entity.Question;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CreateQuestionResponse {
    long id;
    String content;
    List<CreateAnswerResponse> answers;

    public static CreateQuestionResponse of(final Question question) {
        return CreateQuestionResponse.builder()
                .id(question.getId())
                .content(question.getContent())
                .answers(CreateAnswerResponse.of(question.getAnswers()))
                .build();
    }
}
