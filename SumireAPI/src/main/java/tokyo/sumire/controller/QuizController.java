package tokyo.sumire.controller;

import javax.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;
import tokyo.sumire.controller.request.QuizListRequest;
import tokyo.sumire.controller.response.QuizListResponse;
import tokyo.sumire.service.QuizService;

@RestController
@AllArgsConstructor
public class QuizController {

	private final QuizService quizService;

	@GetMapping("/quizlist")
	public QuizListResponse getQuizList(@Valid QuizListRequest request) {
		return new QuizListResponse(this.quizService.getQuizList(request));
	}
}
