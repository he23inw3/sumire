package tokyo.sumire.controller.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.validation.annotation.Validated;

import lombok.Data;

@Data
@Validated
public class QuizListRequest {

	@NotNull
	@Size(min = 8, max = 8)
	private String startDate;

	@NotNull
	@Size(min = 8, max = 8)
	private String endDate;
}
