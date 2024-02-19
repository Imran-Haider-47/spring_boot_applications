package com.imhaider.springbootmysql.repo;

import com.imhaider.springbootmysql.entity.Attempt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttemptRepository extends JpaRepository<Attempt, Long> {
}
