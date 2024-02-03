package com.imhaider.springbootmysql.dto;

import lombok.Data;
import lombok.Value;

@Value
public class CreateAnswerRequest {
    String content;
    boolean isCorrect;
}
