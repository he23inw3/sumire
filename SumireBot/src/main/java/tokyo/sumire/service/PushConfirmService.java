package tokyo.sumire.service;

import java.net.URI;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Service;

import com.linecorp.bot.client.LineMessagingClient;
import com.linecorp.bot.model.Broadcast;
import com.linecorp.bot.model.action.Action;
import com.linecorp.bot.model.action.MessageAction;
import com.linecorp.bot.model.message.Message;
import com.linecorp.bot.model.message.TemplateMessage;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.message.template.CarouselColumn;
import com.linecorp.bot.model.message.template.CarouselTemplate;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tokyo.sumire.constant.LogConstant;
import tokyo.sumire.domain.Choice;
import tokyo.sumire.domain.Quiz;
import tokyo.sumire.repository.QuizRepository;

@Slf4j
@Service
@AllArgsConstructor
public class PushConfirmService {

	/**
	 * クイズサービス
	 */
	private final QuizRepository quizRepository;

	/**
	 * LINEクライアント
	 */
	private final LineMessagingClient lineMessagingClient;

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>クイズ情報配信</dd>
	 * </dl>
	 *
	 */
	public void pushQuizInfo() {
		log.info(LogConstant.LOG001);

		String planDay = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		Quiz quiz = this.quizRepository.getQuiz(planDay);
		if (quiz == null) {
			log.info(LogConstant.LOG004);
			return;
		}

		// 問題文送信
		Message problemMessage = new TextMessage(quiz.getQuestion());
		this.lineMessagingClient.broadcast(new Broadcast(Collections.singletonList(problemMessage), false));

		// 選択肢送信
		List<CarouselColumn> carouselColumns = new ArrayList<>();
		for (Choice choice : quiz.getChoices()) {
			Action action = new MessageAction("この人です!", quiz.getQuizId() + choice.getChoiceId());
			String textMessage = String.format("B%dcm W%dcm H%dcm", choice.getBust(), choice.getWest(), choice.getHip());
			CarouselColumn column = new CarouselColumn(URI.create(choice.getImageUri()), choice.getName(), textMessage, Arrays.asList(action));
			carouselColumns.add(column);
		}
		Message message = new TemplateMessage("選択肢", new CarouselTemplate(carouselColumns));
		this.lineMessagingClient.broadcast(new Broadcast(Collections.singletonList(message), false));

		// 送信済フラグを更新
		this.quizRepository.updateDeliveriedFlg(quiz.getQuizId());

		log.info(LogConstant.LOG002);
	}
}
