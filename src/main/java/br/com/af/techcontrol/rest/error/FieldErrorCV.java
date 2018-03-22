package br.com.af.techcontrol.rest.error;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@JsonInclude(Include.NON_NULL)
@Getter
@Setter
@AllArgsConstructor
public class FieldErrorCV implements Serializable {

	private static final long serialVersionUID = 1L;

	private final String field;

	private final String message;

}
