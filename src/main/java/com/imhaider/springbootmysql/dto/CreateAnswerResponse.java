package com.imhaider.springbootmysql.dto;

import com.imhaider.springbootmysql.entity.Answer;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class CreateAnswerResponse {
    long id;
    String content;
    boolean isCorrect;

    public static CreateAnswerResponse of(final Answer answer) {
        return CreateAnswerResponse.builder()
                .id(answer.getId())
                .content(answer.getContent())
                .isCorrect(answer.isCorrect())
                .build();
    }

    public static List<CreateAnswerResponse> of(final List<Answer> answers) {
        return answers.stream()
                .map(CreateAnswerResponse::of)
                .toList();
    }
}