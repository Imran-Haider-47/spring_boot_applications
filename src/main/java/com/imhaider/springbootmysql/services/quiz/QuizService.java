package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.entity.Quiz;
import com.imhaider.springbootmysql.repo.QuizRepository;
import org.springframework.stereotype.Service;

public interface QuizService {
    Quiz createQuiz(Quiz quiz);
    Quiz getQuizById(Long quizId);
    // Add more methods as needed
}


