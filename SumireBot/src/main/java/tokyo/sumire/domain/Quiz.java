package tokyo.sumire.domain;

import java.util.List;

import lombok.Data;

@Data
public class Quiz {

	/**
	 * クイズID
	 */
	private String quizId;

	/**
	 * 問題文
	 */
	private String question;

	/**
	 * 選択肢
	 */
	private List<Choice> choices;
}
