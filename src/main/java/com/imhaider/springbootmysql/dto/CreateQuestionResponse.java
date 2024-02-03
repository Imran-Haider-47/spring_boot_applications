package com.imhaider.springbootmysql.dto;

import lombok.Value;

import java.util.List;

@Value
public class CreateQuestionRequest {
    String content;
    List<CreateAnswerRequest> answers;
}
