package com.imhaider.springbootmysql.dto.question;


import com.imhaider.springbootmysql.dto.answer.CreateAnswerRequest;

import lombok.Value;

import java.util.List;

@Value
public class CreateQuestionRequest {
    String content;
    List<CreateAnswerRequest> answers;
}
