package com.imhaider.springbootmysql.repo;

import com.imhaider.springbootmysql.entity.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuizRepository extends JpaRepository<Quiz, Long> {

}

