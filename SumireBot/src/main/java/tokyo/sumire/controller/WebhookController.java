package tokyo.sumire.controller;

import org.springframework.stereotype.Controller;

import com.linecorp.bot.model.event.FollowEvent;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.event.UnfollowEvent;
import com.linecorp.bot.model.event.message.TextMessageContent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.spring.boot.annotation.EventMapping;
import com.linecorp.bot.spring.boot.annotation.LineMessageHandler;

import lombok.AllArgsConstructor;
import tokyo.sumire.service.WebhookService;

@LineMessageHandler
@Controller
@AllArgsConstructor
public class WebhookController {

	private final WebhookService webhookService;

	@EventMapping
    public TextMessage handleTextMessageEvent(MessageEvent<TextMessageContent> event) {
		return this.webhookService.handleTextMessageEvent(event);
	}

	@EventMapping
	public TextMessage handleFollowEvent(FollowEvent followEvent) {
		return this.webhookService.handleFollowEventMessage(followEvent);
	}

	@EventMapping
	public void handleUnfollowEvent(UnfollowEvent unfollowEvent) {
		this.webhookService.handleUnFollowEventMessage(unfollowEvent);
	}
}
