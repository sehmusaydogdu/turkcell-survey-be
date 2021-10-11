package com.turkcell.survey.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.turkcell.survey.model.QuestionsAnswered;

public interface IQuestionsAnsweredRepository extends JpaRepository<QuestionsAnswered, Long> {

	Optional<QuestionsAnswered> findByUserIdAndQuestionId(Long userId, Long questionId);
}
