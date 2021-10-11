package com.turkcell.survey.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * Keeps question text.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */
@Entity
@Getter
@Setter
@Table(name = "QUESTIONS")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTIONS_TABLE_SEQUENCE")
	@SequenceGenerator(name = "QUESTIONS_TABLE_SEQUENCE", allocationSize = 1)
	@Column(name = "QUESTION_ID")
	private Long questionId;

	@Column(name = "QUESTION_TEXT", nullable = false)
	private String questionText;

	@OneToMany(mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Answer> answers;
}
