package com.turkcell.survey.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.model.Answer;

public interface IAnswerRepository extends JpaRepository<Answer, Long> {

}
