package tokyo.sumire.util;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.time.LocalDateTime;
import java.time.Month;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ActiveProfiles("local")
@DisplayName("閉塞時間判定処理のテスト")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class DateTimeUtilTest {

	@Autowired
	private DateTimeUtil tested;

	@Test
	@DisplayName("07時00分が閉塞時間外と判定されるかチェック")
	public void between_07時00分が閉塞時間外と判定されるかチェック() {
		LocalDateTime now = LocalDateTime.of(2013, Month.JUNE, 1, 7, 0, 0);
		assertThat(tested.between(now), is(true));
	}

	@Test
	@DisplayName("23時59分が閉塞時間外と判定されるかチェック")
	public void between_23時59分が閉塞時間外と判定されるかチェック() {
		LocalDateTime now = LocalDateTime.of(2013, Month.JUNE, 1, 23, 59, 0);
		assertThat(tested.between(now), is(true));
	}

	@Test
	@DisplayName("06時59分が閉塞時間内と判定されるかチェック")
	public void between_06時59分が閉塞時間外と判定されるかチェック() {
		LocalDateTime now = LocalDateTime.of(2013, Month.JUNE, 1, 6, 59, 0);
		assertThat(tested.between(now), is(false));
	}

	@Test
	@DisplayName("00時00分が閉塞時間内と判定されるかチェック")
	public void between_00時00分が閉塞時間外と判定されるかチェック() {
		LocalDateTime now = LocalDateTime.of(2013, Month.JUNE, 1, 0, 0, 0);
		assertThat(tested.between(now), is(false));
	}
}
