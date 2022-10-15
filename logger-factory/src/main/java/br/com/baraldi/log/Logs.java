package br.com.baraldi.log;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

// Interface para uso de objetos que desejam efetuar Log
// ------------------------------------------------------------
public interface Logs {
	
	public void write(String logText);

	default String getHour() {
		
		// Data e hora atual
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/uuuu HH:mm:ss");
		
		return dtf.format(now);
		
	}
}
