package br.com.af.techcontrol.rest.dto;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ReservaDto {

	private int id;
	private String title;
	private String description;
	private boolean allDay;
	private String start;
	private String end;
	private String url;
	
}