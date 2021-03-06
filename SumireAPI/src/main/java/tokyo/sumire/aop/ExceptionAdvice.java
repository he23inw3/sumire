package tokyo.sumire.aop;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import tokyo.sumire.constant.MsgConstant;
import tokyo.sumire.controller.response.ErrorResponse;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ErrorResponse handleUnExpectedError(Throwable th) {
		log.error("想定外エラー発生", th);
		return new ErrorResponse(MsgConstant.UN_EXPECTED_ERROR_MSG);
	}
}
