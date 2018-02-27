package br.com.af.techcontrol.rest.error;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import br.com.af.techcontrol.rest.response.ApiStatusResponse;
import br.com.af.techcontrol.rest.response.Response;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	@ExceptionHandler(value = { ConstraintViolationException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Response<?> constraintViolationException(ConstraintViolationException ex) {
		return new Response<Object>(new ApiStatusResponse(HttpStatus.BAD_REQUEST.value(), 5001, ex.getMessage()));
	}

	@ExceptionHandler(value = { NoHandlerFoundException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public Response<?> noHandlerFoundException(Exception ex) {
		return new Response<Object>(new ApiStatusResponse(HttpStatus.NOT_FOUND.value(), 4041, ex.getMessage()));
	}

	@ExceptionHandler(value = { Exception.class })
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Response<?> unknownException(Exception ex) {
		return new Response<Object>(new ApiStatusResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), 5002, ex.getMessage()));
	}
}
