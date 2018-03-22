package br.com.af.techcontrol.rest.enums;

public enum ErrorMessages {

	ACCESS_DENIED("error.accessDenied"), 
	UNAUTHORIZED("error.unauthorized"), 
	VALIDATION("error.validation"), 
	METHOD_NOT_SUPPORTED("error.methodNotSupported"), 
	INTERNAL_SERVER_ERROR("error.internalServerError");

	private String message;

	private ErrorMessages(String key) {
		this.message = key;
	}

	public String getMessage() {
		return message;
	}
	
}

