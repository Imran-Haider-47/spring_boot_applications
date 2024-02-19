package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.answer.CreateAnswerRequest;
import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.entity.AttemptedQuiz;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.repo.AnswerRepository;
import com.imhaider.springbootmysql.repo.AttemptedQuizRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AnswerService {

    private final AnswerRepository answerRepository;

    public AnswerService(AnswerRepository answerRepository, AttemptedQuizRepository attemptedQuizRepository) {
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

    public Answer updateAnswer(Long answerId, CreateAnswerRequest answerRequest){
        Answer answer  = getAnswerById(answerId);
        if(!answer.getContent().isEmpty()){
            answer.setContent(answerRequest.getContent());
            answer.setCorrect(answerRequest.isCorrect());
        }
        return answerRepository.save(answer);
    }

    public String deleteAnswer(Long answerId){
        Answer answer = this.getAnswerById(answerId);
        if(answer != null){
            answerRepository.deleteById(answerId);
            return "Answer Deleted Successfully.";
        } else {
            throw new RuntimeException("Message: Answer was not found.");
        }
    }

    // Implement other methods like fetching all answers, updating answers, deleting answers, etc.
}
