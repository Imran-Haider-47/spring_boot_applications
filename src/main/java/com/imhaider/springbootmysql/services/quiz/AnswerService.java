package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.repo.AnswerRepository;
import com.imhaider.springbootmysql.services.quiz.interfaces.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerServiceImpl(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    @Override
    public Answer createAnswer(Answer answer) {
        return answerRepository.save(answer);
    }


    @Override
    public Answer getAnswerById(Long answerId) {
        return answerRepository.findById(answerId).orElse(null);
    }

    // Implement other methods like fetching all answers, updating answers, deleting answers, etc.
}
