package tokyo.sumire.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import tokyo.sumire.config.LineProperties;

@Component
@AllArgsConstructor
public class DateTimeUtil {

	private final LineProperties lineProperties;

	/**
	 * <dl>
	 * <dt><b>メソッド概要: </b></dt>
	 * <dd>期間内判定</dd>
	 * </dl>
	 *
	 * @param now 現在日付
	 * @return TRUE: ボット利用可能、FALSE: ボット利用不可
	 */
	public boolean between(LocalDateTime now) {
		String nowStr = now.format(DateTimeFormatter.ofPattern("HH:mm:ss"));
		// Bot利用可能時間帯の場合
		if (nowStr.compareTo(lineProperties.getStartTime()) >= 0 &&
				nowStr.compareTo(lineProperties.getEndTime()) <= 0) {
			return true;
		}

		return false;
	}

}
