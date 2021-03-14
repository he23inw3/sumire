package tokyo.sumire.controller.response;

import java.util.List;

import lombok.Data;
import tokyo.sumire.domain.Quiz;
import tokyo.sumire.domain.QuizList;

@Data
public class QuizListResponse {

	public QuizListResponse(QuizList quizList) {
		this.totalQuizCnt = quizList.getTotalQuizCnt();
		this.quizList = quizList.getQuizList();
	}

	/**
	 * クイズID
	 */
	private int totalQuizCnt;

	/**
	 * 選択肢
	 */
	private List<Quiz> quizList;
}
