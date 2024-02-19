package com.imhaider.springbootmysql.dto.question;

import com.imhaider.springbootmysql.dto.answer.CreateAnswerResponse;
import com.imhaider.springbootmysql.entity.Question;
import lombok.Builder;
import lombok.Value;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    public static Set<CreateQuestionResponse> of(final Set<Question> questions) {
        return questions.stream()
                .map(CreateQuestionResponse::of)
                .collect(Collectors.toSet());
    }

}
