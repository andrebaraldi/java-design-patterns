package br.com.baraldi.logger.screen;

import br.com.baraldi.log.Logs;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class LogsScreen implements Logs {

	// Escreve o Log
	// ------------------
	@Override
	public void write(String logText) {
		
		
		System.out.println(this.getHour() + "........"+ logText);
	}
	
}




