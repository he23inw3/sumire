package tokyo.sumire.repository;

import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import tokyo.sumire.domain.Answer;
import tokyo.sumire.domain.Quiz;

@Repository
@Mapper
public interface QuizRepository {

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>クイズ取得</dd>
	 * </dl>
	 *
	 * @param planDay 企画日
	 * @return クイズ情報
	 */
	Quiz getQuiz(String planDay);

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>選択肢からおすすめビデオを算出</dd>
	 * </dl>
	 *
	 * @param paramMap パラメーターマップ
	 * @return 女優ID
	 */
	String getResourceUri(Map<String, String> paramMap);

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>回答したクイズの回答が配信した日と同様かチェック</dd>
	 * </dl>
	 * @param quizId クイズId
	 * @return 検証結果
	 */
	boolean validateAnswer(String quizId);

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>送信済フラグを更新</dd>
	 * </dl>
	 *
	 * @param quizId クイズId
	 */
	@Transactional
	void updateDeliveriedFlg(String quizId);

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>回答チェック</dd>
	 * </dl>
	 *
	 * @param answer 回答
	 * @return 回答結果
	 */
	boolean checkAnswer(Answer answer);


	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>回答済チェック</dd>
	 * </dl>
	 *
	 * @param answer 回答
	 * @return 結果
	 */
	boolean checkRegistedAnswer(Answer answer);

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>答え登録</dd>
	 * </dl>
	 *
	 * @param answer 回答
	 */
	@Transactional
	void registAnswer(Answer answer);
}
