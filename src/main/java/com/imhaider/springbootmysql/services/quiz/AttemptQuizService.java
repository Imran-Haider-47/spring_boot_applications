package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.quiz.AttemptQuizRequest;
import com.imhaider.springbootmysql.dto.AttemptedQuestionRequest;
import com.imhaider.springbootmysql.entity.*;
import com.imhaider.springbootmysql.repo.AttemptRepository;
import com.imhaider.springbootmysql.repo.AttemptedQuizRepository;
import org.springframework.stereotype.Service;

@Service
public class AttemptQuizService {
    private final AttemptedQuizRepository attemptedQuizRepository;
    private final QuestionService questionService;
    private final AnswerService answerService;
    private final QuizService quizService;
    private final AttemptRepository attemptRepository;

    public AttemptQuizService(AttemptedQuizRepository attemptedQuizRepository, QuestionService questionService, AnswerService answerService, QuizService quizService, AttemptRepository attemptRepository) {
        this.attemptedQuizRepository = attemptedQuizRepository;
        this.questionService = questionService;
        this.answerService = answerService;
        this.quizService = quizService;
        this.attemptRepository = attemptRepository;
    }


    public float calculateScore(AttemptQuizRequest attemptedQuizRequest) {
        Quiz quiz = quizService.getQuizById(attemptedQuizRequest.getQuizId());
        Attempt attempt = new Attempt();
        attempt.setQuiz(quiz);
        attemptRepository.save(attempt);

        float score = 0;

        for (AttemptedQuestionRequest questionRequest : attemptedQuizRequest.getAttemptedQuestions()) {
            Long questionId = questionRequest.getQuestionId();
            Long answerId = questionRequest.getAnswerId();

            Question question = questionService.getQuestionById(questionId);
            Answer answer = answerService.getAnswerById(answerId);

            if (question != null && answer != null) {
                AttemptedQuiz attemptedQuiz = new AttemptedQuiz();
                attemptedQuiz.setQuiz(quiz);
                attemptedQuiz.setAttempt(attempt);
                attemptedQuiz.setQuestion(question);
                attemptedQuiz.setAnswer(answer);
                attemptedQuizRepository.save(attemptedQuiz);

                if (answer.isCorrect()) {
                    score++;
                }
            }
        }

        return score;
    }
}

