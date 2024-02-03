package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.CreateAnswerRequest;
import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.repo.AnswerRepository;
import org.springframework.stereotype.Service;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository) {
        this.answerRepository = answerRepository;
    }

    public Answer createAnswer(CreateAnswerRequest answerRequest, Question question) {
        Answer answer = Answer.builder()
                .content(answerRequest.getContent())
                .isCorrect(answerRequest.isCorrect())
                .question(question)
                .build();
        return answerRepository.save(answer);
    }

    public Answer getAnswerById(Long answerId) {
        return answerRepository.findById(answerId).orElse(null);
    }

    // Implement other methods like fetching all answers, updating answers, deleting answers, etc.
}
