package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.entity.Quiz;
import com.imhaider.springbootmysql.services.quiz.QuizService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;

    public QuizController(QuizService quizService) {
        this.quizService = quizService;
    }

    @PostMapping
    public Quiz createQuiz(@RequestBody Quiz quiz) {
        return quizService.createQuiz(quiz);
    }

    @GetMapping("/{quizId}")
    public Quiz getQuizById(@PathVariable Long quizId) {
        return quizService.getQuizById(quizId);
    }

    // Add more endpoints for fetching all quizzes, updating quizzes, deleting quizzes, etc.
}

