package com.imhaider.springbootmysql.dto;

import jakarta.persistence.Version;
import lombok.Value;

@Value
public class AttemptedQuestionRequest {
    Long questionId;
    Long answerId;
}
