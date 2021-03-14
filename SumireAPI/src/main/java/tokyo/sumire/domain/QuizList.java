package tokyo.sumire.domain;

import java.util.List;

import lombok.Data;

@Data
public class QuizList {

	private int totalQuizCnt;

	private List<Quiz> quizList;
}
