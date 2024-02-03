package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.dto.CreateQuestionRequest;
import com.imhaider.springbootmysql.dto.CreateQuestionResponse;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.services.quiz.QuestionService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionService questionService;

    @PostMapping
    public ResponseEntity<CreateQuestionResponse> createQuestion(@RequestBody CreateQuestionRequest questionRequest) {
        Question question = questionService.createQuestion(questionRequest);
        return ResponseEntity.ok(CreateQuestionResponse.of(question));
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId) {
        return questionService.getQuestionById(questionId);
    }

}

