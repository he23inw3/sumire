package tokyo.sumire.domain;

import java.util.Date;

import lombok.Data;

@Data
public class Answer {

	/**
	 * ユーザーID
	 */
	private String userId;

	/**
	 * クイズID
	 */
	private String quizId;

	/**
	 * 選択肢ID
	 */
	private String choiceId;

	private Date answeredDatetime;
}
