package tokyo.sumire.service;

import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.linecorp.bot.client.LineMessagingClient;

import tokyo.sumire.domain.Choice;
import tokyo.sumire.domain.Quiz;
import tokyo.sumire.repository.QuizRepository;

@ActiveProfiles("local")
@DisplayName("クイズ送信機能のテスト")
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PushConfirmServiceTest {

	@Autowired
	private PushConfirmService tested;

	@MockBean
	private QuizRepository mockQuizRepository;

	@MockBean
	private LineMessagingClient mockLineMessagingClient;

	@Test
	public void test() {
		// setup
		when(mockQuizRepository.getQuiz(anyString())).thenReturn(null);

		// execeice
		tested.pushQuizInfo();

		// verify
	}

	@Test
	public void test2() {
		// setup
		Quiz quiz = new Quiz();
		quiz.setQuizId("00000001");
		quiz.setQuestion("test");
		Choice choice = new Choice();
		choice.setChoiceId("00000001");
		choice.setName("test name");
		choice.setImageUri("http://www.test.org");
		choice.setBust(86);
		choice.setHip(80);
		choice.setWest(88);
		quiz.setChoices(Arrays.asList(choice));
		when(mockQuizRepository.getQuiz(anyString())).thenReturn(quiz);

		// execeice
		tested.pushQuizInfo();
	}

}
