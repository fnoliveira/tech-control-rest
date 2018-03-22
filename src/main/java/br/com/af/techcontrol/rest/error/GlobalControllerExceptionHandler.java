package br.com.af.techcontrol.rest.error;

import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import br.com.af.techcontrol.rest.enums.ErrorMessages;

@RestControllerAdvice
public class GlobalControllerExceptionHandler {

	private static final String FIELD_PREFIX = "arg0.";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCV processMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

		ErrorCV dto = new ErrorCV(ErrorMessages.VALIDATION.getMessage());

		BindingResult result = ex.getBindingResult();

		List<ObjectError> globalErrors = result.getGlobalErrors();
		globalErrors.forEach(objectError -> {
			dto.add(objectError.getObjectName(), objectError.getDefaultMessage());
		});

		List<FieldError> fieldErrors = result.getFieldErrors();
		fieldErrors.forEach(fieldError -> {
			dto.add(fieldError.getField(), fieldError.getDefaultMessage());
		});

		return dto;
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorCV processConstraintViolationException(ConstraintViolationException ex) {
		ErrorCV dto = new ErrorCV(ErrorMessages.VALIDATION.getMessage());

		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		violations.forEach(violation -> {
			String field = violation.getPropertyPath().toString();
			dto.add(field.substring(field.lastIndexOf(FIELD_PREFIX) + FIELD_PREFIX.length()), violation.getMessage());
		});

		return dto;
	}

	@ExceptionHandler(AccessDeniedException.class)
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public ErrorCV processAccessDeniedException(AccessDeniedException e) {
		return new ErrorCV(ErrorMessages.ACCESS_DENIED.getMessage(), e.getMessage());
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	public ErrorCV processMethodNotSupportedException(HttpRequestMethodNotSupportedException exception) {
		return new ErrorCV(ErrorMessages.METHOD_NOT_SUPPORTED.getMessage(), exception.getMessage());
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorCV> unknownException(Exception exception) {
		BodyBuilder builder;
		ErrorCV error;
		ResponseStatus responseStatus = AnnotationUtils.findAnnotation(exception.getClass(), ResponseStatus.class);

		if (responseStatus != null) {
			builder = ResponseEntity.status(responseStatus.value());
			error = new ErrorCV("error." + responseStatus.value(), responseStatus.reason());
		} else {
			builder = ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR);
			error = new ErrorCV(ErrorMessages.INTERNAL_SERVER_ERROR.getMessage(), exception.getMessage());
		}

		return builder.body(error);
	}
}
