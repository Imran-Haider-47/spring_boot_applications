package com.imhaider.springbootmysql.services.quiz;

import com.imhaider.springbootmysql.dto.question.CreateQuestionRequest;
import com.imhaider.springbootmysql.entity.Answer;
import com.imhaider.springbootmysql.entity.Question;
import com.imhaider.springbootmysql.repo.QuestionRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

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
        List<Question> existingQuestions = questionRepository.findAll();

        boolean isContentUnique = existingQuestions.stream()
                .noneMatch(existingQuestion -> existingQuestion.getContent().equals(question.getContent()));

        if (isContentUnique) {
            Question savedQuestion = questionRepository.save(question);

            List<Answer> answers = questionRequest.getAnswers().stream()
                    .map(answer -> answerService.createAnswer(answer, savedQuestion))
                    .toList();
            question.setAnswers(answers);
        }
        else {
            throw new RuntimeException("Question with the same content already exists");
        }
        return question;
    }

    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId).orElse(null);
    }
    public List<Question> getAllQuestions(){
        List<Question> questions = questionRepository.findAll();
        if (questions.isEmpty()) {
            throw new RuntimeException("No questions found in the database.");
        }
        return questions;
    }
    public Question updateQuestion(Long id, CreateQuestionRequest questionRequest){
        Question question = getQuestionById(id);
        if(!questionRequest.getContent().isEmpty()) {
            question.setContent(questionRequest.getContent());
        }
        questionRepository.save(question);
        return question;

    }
    public String deleteQuestion(Long id){
        Optional<Question> question = questionRepository.findById(id);
        if(question.isPresent()){
            questionRepository.deleteById(id);
            return "Question deleted Successfully.";
        }
        else {
            throw new RuntimeException("Message: The question was not found!");
        }
    }


    // Implement other methods like fetching all questions, updating questions, deleting questions, etc.

}

