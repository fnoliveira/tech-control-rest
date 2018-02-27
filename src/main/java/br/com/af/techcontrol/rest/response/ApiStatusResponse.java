package br.com.af.techcontrol.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApiStatusResponse {

	private int httpStatusCode;

	private int retCode;

	private String message;

}