package com.imhaider.springbootmysql.dto.answer;

import lombok.Data;
import lombok.Value;

@Value
public class CreateAnswerRequest {
    String content;
    boolean isCorrect;
}
