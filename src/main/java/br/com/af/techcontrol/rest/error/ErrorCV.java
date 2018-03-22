package br.com.af.techcontrol.rest.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Getter;

@JsonInclude(Include.NON_NULL)
public class ErrorCV implements Serializable {

	private static final long serialVersionUID = 1L;

	@Getter
	private final String message;

	@Getter
	private final String description;

	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@Getter
	private List<FieldErrorCV> fieldErrors;

	@Getter
	private final String docs = "/restful-error-codes";

	public ErrorCV(String message) {
		this(message, null);
	}

	public ErrorCV(String message, String description) {
		this.message = message;
		this.description = description;
	}

	public ErrorCV(String message, String description, List<FieldErrorCV> fieldErrors) {
		this.message = message;
		this.description = description;
		this.fieldErrors = fieldErrors;
	}

	public ErrorCV(HttpStatus status, String description) {
		this(status.name(), description);
	}

	public void add(String field, String message) {
		if (fieldErrors == null) {
			fieldErrors = new ArrayList<>();
		}
		fieldErrors.add(new FieldErrorCV(field, message));
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

}
