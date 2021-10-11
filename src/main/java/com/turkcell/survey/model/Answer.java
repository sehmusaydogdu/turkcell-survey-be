package com.turkcell.survey.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * Keeps answers associated with questions.
 * 
 * @author Şeyhmus Aydoğdu
 *
 */

@Entity
@Getter
@Setter
@Table(name = "ANSWERS")
public class Answer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ANSWERS_TABLE_SEQUENCE")
	@SequenceGenerator(name = "ANSWERS_TABLE_SEQUENCE", allocationSize = 1)
	@Column(name = "ANSWER_ID")
	private Long answerId;

	@JsonIgnore
	@Column(name = "QUESTION_ID", nullable = false, insertable = false, updatable = false)
	private Long questionId;

	@Column(name = "ANSWER_TEXT", nullable = false)
	private String answerText;

	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "QUESTION_ID", nullable = false)
	private Question question;
}
