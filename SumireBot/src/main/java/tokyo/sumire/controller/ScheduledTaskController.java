package tokyo.sumire.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import tokyo.sumire.service.PushConfirmService;


@Controller
@Slf4j
@AllArgsConstructor
public class ScheduledTaskController {

	private final PushConfirmService pushConfirmService;

	@Scheduled(cron = "${av.quiz.cron}", zone = "Asia/Tokyo")
	public void executePushQuiz() {
		pushConfirmService.pushQuizInfo();
		log.info("cron task executed : " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
	}
}
