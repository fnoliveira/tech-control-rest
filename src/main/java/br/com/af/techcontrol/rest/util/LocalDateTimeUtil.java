package br.com.af.techcontrol.rest.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtil {
	
	public static LocalDateTime strToLocalDateTime(String data, String format) {
		LocalDateTime retorno;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format); 
		retorno = LocalDateTime.parse(data, formatter);
		return retorno;
	}

}
