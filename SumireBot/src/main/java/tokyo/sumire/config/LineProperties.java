package tokyo.sumire.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties(prefix = "line.bot")
public class LineProperties {

	private String startTime;

	private String endTime;
}
