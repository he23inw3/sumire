package tokyo.sumire.domain;

import java.util.Date;
import java.util.List;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Quiz {

	/**
	 * クイズID
	 */
	private String quizId;

	/**
	 * 企画日
	 */
	private Date planDay;

	/**
	 * 問題文
	 */
	private String question;

	/**
	 * 選択肢
	 */
	private List<Choice> choices;
}
