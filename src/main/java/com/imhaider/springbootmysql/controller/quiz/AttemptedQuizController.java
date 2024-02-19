package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.dto.quiz.AttemptQuizRequest;
import com.imhaider.springbootmysql.services.quiz.AttemptQuizService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes/attempt")
public class AttemptedQuizController {
    private final AttemptQuizService attemptQuizService;


    public AttemptedQuizController(AttemptQuizService attemptQuizService) {
        this.attemptQuizService = attemptQuizService;
    }

    @PostMapping
    public float CreateAttemptQuiz(@RequestBody AttemptQuizRequest attemptQuizRequest) {

        float attemptedQuiz= attemptQuizService.calculateScore(attemptQuizRequest);
        System.out.println(attemptedQuiz);
        return attemptedQuiz;
    }

}
