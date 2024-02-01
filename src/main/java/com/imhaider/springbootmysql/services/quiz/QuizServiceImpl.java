package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.entity.Quiz;
import com.imhaider.springbootmysql.repo.QuizRepository;
import org.springframework.stereotype.Service;

@Service
public class QuizServiceImpl implements QuizService {
    private final QuizRepository quizRepository;

    public QuizServiceImpl(QuizRepository quizRepository) {
        this.quizRepository = quizRepository;
    }

    @Override
    public Quiz createQuiz(Quiz quiz) {
        return quizRepository.save(quiz);
    }

    @Override
    public Quiz getQuizById(Long quizId) {
        return quizRepository.findById(quizId).orElse(null);
    }

    // Implement other methods like fetching random quiz questions, calculating scores, etc.
}
