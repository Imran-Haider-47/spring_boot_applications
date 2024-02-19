package com.imhaider.springbootmysql.repo;

import com.imhaider.springbootmysql.entity.AttemptedQuiz;
import com.imhaider.springbootmysql.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptedQuizRepository extends JpaRepository<AttemptedQuiz, Long>{
}
