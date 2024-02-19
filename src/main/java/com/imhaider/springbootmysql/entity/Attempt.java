package com.imhaider.springbootmysql.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Table(name="answer")
@Builder
@Entity
public class Attempt extends Identity {


    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;
}
