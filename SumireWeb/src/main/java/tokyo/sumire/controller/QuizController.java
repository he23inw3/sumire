package tokyo.sumire.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;
import tokyo.sumire.service.QuizService;

@Controller
@AllArgsConstructor
public class QuizController {

	private final QuizService quizService;

	/**
	 * クイズ選択画面
	 * @return
	 */
	@RequestMapping(path="/select_quiz", method=RequestMethod.GET)
	public String select(Model model) {
		model.addAttribute("quizList", this.quizService.getQuizList());
		return "select_quiz";
	}

	/**
	 * クイズ画面
	 * @return
	 */
	@RequestMapping(path="/quiz", method=RequestMethod.GET)
	public String quiz(@RequestParam(name = "quizId", required = true) String quizId,
			Model model) {
		model.addAttribute("quiz", this.quizService.getQuizDetail(quizId));
		return "quiz";
	}
}
