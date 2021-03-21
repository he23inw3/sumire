package tokyo.sumire.domain;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class Quiz {

	/**
	 * クイズID
	 */
	private String quizId;

	/**
	 * 企画日
	 */
	private LocalDate planDay;

	/**
	 * 問題文
	 */
	private String question;

	/**
	 * 選択肢
	 */
	private List<Choice> choices;
}
