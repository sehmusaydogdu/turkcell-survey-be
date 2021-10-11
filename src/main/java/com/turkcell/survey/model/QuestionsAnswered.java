package com.turkcell.survey.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.turkcell.survey.authentication.model.UserInfo;

import lombok.Getter;
import lombok.Setter;

/**
 * Who keeps what answer to which question
 * 
 * @author acer
 *
 */

@Entity
@Getter
@Setter
@Table(name = "QUESTIONS_ANSWERED")
public class QuestionsAnswered {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "QUESTIONS_ANSWERED_TABLE_SEQUENCE")
	@SequenceGenerator(name = "QUESTIONS_ANSWERED_TABLE_SEQUENCE", allocationSize = 1)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "ANSWERED_DATE")
	private Date answeredDate;

	@Column(name = "ANSWER_ID")
	private Long answerId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "ANSWER_ID", referencedColumnName = "ANSWER_ID", insertable = false, updatable = false)
	private Answer answerInfo;

	@Column(name = "QUESTION_ID")
	private Long questionId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "QUESTION_ID", referencedColumnName = "QUESTION_ID", insertable = false, updatable = false)
	private Question questionInfo;

	@Column(name = "USER_ID")
	private Long userId;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID", insertable = false, updatable = false)
	private UserInfo userInfo;
}
