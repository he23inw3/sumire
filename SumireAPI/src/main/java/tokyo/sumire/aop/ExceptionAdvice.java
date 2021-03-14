package tokyo.sumire.aop;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import tokyo.sumire.constant.MsgConstant;
import tokyo.sumire.controller.response.ErrorResponse;
import tokyo.sumire.exception.NotFoundResourceException;

@Slf4j
@RestControllerAdvice
public class ExceptionAdvice {

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({
			MissingServletRequestParameterException.class,
			ConstraintViolationException.class,
			BindException.class
	})
	@ResponseBody
	public ErrorResponse handleRequestError(Throwable th) {
		log.error("リクエストエラー発生");
		return new ErrorResponse(MsgConstant.REQUEST_ERROR_MSG);
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler({
			NotFoundResourceException.class
	})
	@ResponseBody
	public ErrorResponse handleNotFoundError(Throwable th) {
		log.error("検索エラー発生");
		return new ErrorResponse(MsgConstant.NOT_FOUND_ERROR_MSG);
	}

	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Throwable.class)
	@ResponseBody
	public ErrorResponse handleUnExpectedError(Throwable th) {
		log.error("想定外エラー発生", th);
		return new ErrorResponse(MsgConstant.UN_EXPECTED_ERROR_MSG);
	}
}
