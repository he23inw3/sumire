package tokyo.sumire.service;

import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tokyo.sumire.domain.Quiz;
import tokyo.sumire.repository.QuizRepository;

@Service
@AllArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;

	public List<Quiz> getQuizList() {
		return this.quizRepository.getQuizList();
	}

	public Quiz getQuizDetail(String quizId) {
		return this.quizRepository.getQuizDetail(quizId);
	}

}
