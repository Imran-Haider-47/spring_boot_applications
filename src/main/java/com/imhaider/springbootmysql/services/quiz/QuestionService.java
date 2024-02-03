package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.CreateQuestionRequest;
import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.repo.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class QuestionService {

    private final QuestionRepository questionRepository;
    private final AnswerService answerService;

    public QuestionService(QuestionRepository questionRepository, AnswerService answerService) {
        this.questionRepository = questionRepository;
        this.answerService = answerService;
    }

    @Transactional
    public Question createQuestion(CreateQuestionRequest questionRequest) {
        Question question = new Question();
        question.setContent(questionRequest.getContent());
        Question savedQuestion = questionRepository.save(question);

        List<Answer> answers=questionRequest.getAnswers().stream()
                .map(answer -> answerService.createAnswer(answer, savedQuestion))
                .toList();
        question.setAnswers(answers);
        return question;
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }

    // Implement other methods like fetching all questions, updating questions, deleting questions, etc.
}

