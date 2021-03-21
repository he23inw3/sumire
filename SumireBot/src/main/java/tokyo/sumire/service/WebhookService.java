package tokyo.sumire.service;

import java.sql.Timestamp;
import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.UnfollowEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;

import lombok.AllArgsConstructor;
import tokyo.sumire.constant.MsgConstant;
import tokyo.sumire.domain.Answer;
import tokyo.sumire.domain.User;
import tokyo.sumire.repository.QuizRepository;
import tokyo.sumire.repository.UserRepository;
import tokyo.sumire.util.DateTimeUtil;

@Service
@AllArgsConstructor
public class WebhookService {

	/**
	 * クイズサービス
	 */
	private final QuizRepository quizRepository;

	/**
	 * DateTimeUtil
	 */
	private final DateTimeUtil dateTimeUtil;

	/**
	 * ユーザーサービス
	 */
	private final UserRepository userRepository;

	/**
	 * <dl>
	 * <dt><b>メソッド機能概要: </b></dt>
	 * <dd>メッセージハンドル</dd>
	 * </dl>
	 *
	 * @param event イベント
	 * @return テキスト
	 */
	public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {

		// 閉塞時間のチェック
		@SuppressWarnings("static-access")
		LocalDateTime now = Timestamp.from(event.getTimestamp().now()).toLocalDateTime();
		if (!dateTimeUtil.between(now)) {
			return new TextMessage(MsgConstant.MSG001);
		}

		// ID取得
		String userId = event.getSource().getUserId();
		String quizId = event.getMessage().getText().substring(0, 8);
		String choiceId = event.getMessage().getText().substring(8, 16);

		// 指定期間内かどうかチェック
		if (this.quizRepository.validateAnswer(quizId)) {
			return new TextMessage(MsgConstant.MSG002);
		}

		// 回答済みか確認
		Answer answer = new Answer();
		answer.setQuizId(quizId);
		answer.setChoiceId(choiceId);
		answer.setUserId(userId);
		if (this.quizRepository.checkRegistedAnswer(answer)) {
			return new TextMessage(MsgConstant.MSG003);
		}

		// 回答確認
		boolean correctFlg = this.quizRepository.checkAnswer(answer);

		// 応答
		String message = MsgConstant.MSG005;
		if (correctFlg) {
			String resourceUri = this.quizRepository.getResourceUri(answer);
			message = String.format(MsgConstant.MSG004, resourceUri);
		}

		// 答えの履歴を登録
		this.quizRepository.registAnswer(answer);

		return new TextMessage(message);
	}

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>友達登録時の処理</dd>
	 * </dl>
	 *
	 * @param followEvent フォローイベント
	 * @return テキスト
	 */
	public TextMessage handleFollowEventMessage(FollowEvent followEvent) {
		User user = new User();
		user.setUserId(followEvent.getSource().getUserId());
		this.userRepository.registUser(user);
		return new TextMessage(MsgConstant.MSG006);
	}

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>友達登録解除時の処理</dd>
	 * </dl>
	 *
	 * @param unfollowEvent アンフォローイベント
	 * @return テキスト
	 */
	public void handleUnFollowEventMessage(UnfollowEvent unfollowEvent) {
		User user = new User();
		user.setUserId(unfollowEvent.getSource().getUserId());
		this.userRepository.unregistUser(user);
	}
}
