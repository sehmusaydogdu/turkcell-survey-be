package com.turkcell.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.model.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
