package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.CreateQuestionRequest;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.repo.QuestionRepository;
import com.imhaider.springbootmysql.services.quiz.interfaces.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;

    public QuestionServiceImpl(QuestionRepository questionRepository) {
        this.questionRepository = questionRepository;
    }

    @Override
    public Question createQuestion(CreateQuestionRequest questionRequest) {

        return questionRepository.save(question);
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    // Implement other methods like fetching all questions, updating questions, deleting questions, etc.
}

