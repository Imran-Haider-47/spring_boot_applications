package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.quiz.CreateQuizRequest;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.entity.Quiz;
import com.imhaider.springbootmysql.entity.User;
import com.imhaider.springbootmysql.repo.QuizRepository;
import com.imhaider.springbootmysql.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.util.*;

@Service
public class QuizService {
    private final QuizRepository quizRepository;
    private final QuestionService questionService;
    private final UserService userService;

    public QuizService(QuizRepository quizRepository, QuestionService questionService, UserService userService) {
        this.quizRepository = quizRepository;
        this.questionService = questionService;
        this.userService = userService;
    }

    public Quiz createQuiz(CreateQuizRequest quizTitle, Authentication authentication) {
        List<Question> allQuestions = questionService.getAllQuestions();
        Collections.shuffle(allQuestions);
        List<Question>questions = allQuestions.subList(0, 2);
        if (questions.size() != 2) {
            throw new IllegalArgumentException("A quiz must contain exactly 2 questions.");
        }
        String userName = ((UserDetails) authentication.getPrincipal()).getUsername();
        Optional<User> user = userService.getUser(userName);

        Quiz quiz = new Quiz();
        quiz.setTitle(quizTitle.getTitle());
        user.ifPresent(quiz::setUser);

        quiz.getQuestions().addAll(questions);
        return quizRepository.save(quiz);
    }

    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }


}

