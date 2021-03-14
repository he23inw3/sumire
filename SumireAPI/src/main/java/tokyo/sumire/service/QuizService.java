package tokyo.sumire.service;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;
import tokyo.sumire.controller.request.QuizListRequest;
import tokyo.sumire.domain.QuizList;
import tokyo.sumire.exception.NotFoundResourceException;
import tokyo.sumire.repository.QuizRepository;

@Service
@AllArgsConstructor
public class QuizService {

	private final QuizRepository quizRepository;

	public QuizList getQuizList(QuizListRequest request) {
		QuizList quizList = this.quizRepository.getQuizList(request.getStartDate(), request.getEndDate());
		if (quizList == null) {
			throw new NotFoundResourceException();
		}

		return quizList;
	}
}
