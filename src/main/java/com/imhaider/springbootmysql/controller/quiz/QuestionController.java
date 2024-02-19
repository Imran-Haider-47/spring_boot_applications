package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.dto.question.CreateQuestionRequest;
import com.imhaider.springbootmysql.dto.question.CreateQuestionResponse;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.services.quiz.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Repeatable;

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

    @PutMapping("/{questionId}")
    public ResponseEntity<CreateQuestionResponse> updateQuestion(@PathVariable Long questionId, @RequestBody CreateQuestionRequest questionRequest){
        Question question = questionService.updateQuestion(questionId,questionRequest);
        return ResponseEntity.ok(CreateQuestionResponse.of(question));
    }

    @GetMapping("/{questionId}")
    public Question getQuestionById(@PathVariable Long questionId) {
        return questionService.getQuestionById(questionId);
    }
    @DeleteMapping("/{questionId}")
    public String deleteQuestionById(@PathVariable Long questionId){
        return questionService.deleteQuestion(questionId);
    }

}

