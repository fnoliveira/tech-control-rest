package br.com.af.techcontrol.rest.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Response<T> {
		
	private T data;
	
	private ApiStatusResponse status;
	
	public Response(T data) {
		this.data = data;
	}
	
	public Response(ApiStatusResponse status) {
		this.status= status;
	}

}
