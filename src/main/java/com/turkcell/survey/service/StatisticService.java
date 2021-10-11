package com.turkcell.survey.service;

import java.sql.Types;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import com.turkcell.survey.exception.DataNotFoundException;
import com.turkcell.survey.model.AnswerResult;
import com.turkcell.survey.model.Question;
import com.turkcell.survey.model.Statistics;

@Service
public class StatisticService {

	@Autowired
	private IQuestionService service;

	@Autowired
	private JdbcTemplate jdbcTemplate;

	private static final String SQL = "SELECT a.ANSWER_TEXT as option, t.ANSWER_ID as option_no, count(*) count from QUESTIONS_ANSWERED t, ANSWERS a WHERE a.answer_id = t.ANSWER_ID AND t.question_id = ? GROUP BY a.answer_id";

	public Statistics getStatistics(Long questionId) throws DataNotFoundException {

		Question question = service.findByQuestionId(questionId);

		Statistics statistic = new Statistics();
		statistic.setQuestion(question.getQuestionText());

		List<AnswerResult> answerResults = jdbcTemplate.query(SQL, new Object[] { questionId },
				new int[] { Types.INTEGER }, new BeanPropertyRowMapper<>(AnswerResult.class));

		statistic.setResult(answerResults);

		return statistic;
	}
}
