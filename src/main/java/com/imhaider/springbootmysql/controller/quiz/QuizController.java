package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.dto.quiz.CreateQuizRequest;
import com.imhaider.springbootmysql.dto.quiz.CreateQuizResponse;
import com.imhaider.springbootmysql.entity.Quiz;
import com.imhaider.springbootmysql.services.quiz.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public ResponseEntity<CreateQuizResponse> createQuiz(@RequestBody CreateQuizRequest quizRequest, Authentication authentication) {
        Quiz quiz = quizService.createQuiz(quizRequest, authentication);
        System.out.println(quiz);
        return ResponseEntity.ok(CreateQuizResponse.of(quiz));
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable Long quizId) {
        return quizService.getQuizById(quizId);
    }

    // Add more endpoints for fetching all quizzes, updating quizzes, deleting quizzes, etc.
}

