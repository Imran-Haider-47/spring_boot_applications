package com.imhaider.springbootmysql.controller.quiz;

import com.imhaider.springbootmysql.dto.CreateAnswerRequest;
import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.services.quiz.AnswerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/answers")
public class AnswerController {

    private final AnswerService answerService;

    public AnswerController(AnswerService answerService) {
        this.answerService = answerService;
    }

//    @PostMapping
//    public Answer createAnswer(@RequestBody CreateAnswerRequest answer) {
//        return answerService.createAnswer(answer, savedQuestion.getId());
//    }

    @GetMapping("/{answerId}")
    public Answer getAnswerById(@PathVariable Long answerId) {
        return answerService.getAnswerById(answerId);
    }

    // Add more endpoints for fetching all answers, updating answers, deleting answers, etc.
}

