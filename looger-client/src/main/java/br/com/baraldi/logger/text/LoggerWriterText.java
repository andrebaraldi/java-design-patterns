package br.com.baraldi.logger.text;

// Lib
import br.com.baraldi.log.Logs;
import br.com.baraldi.logger.LoggerWriter;

// Client
import br.com.baraldi.logger.text.LogsText;


public class LoggerWriterText extends LoggerWriter {

    	private String arquivo;
    
    	// Construtor
    	public LoggerWriterText(String arquivo) {
    	    this.arquivo = arquivo;
    	}
    
    	
    	// Methods from LogWritter
    	// -------------------------------------------
	// Aqui retornamos o tipo de writer para nós
	@Override
	public Logs getLogger() {
	    return new LogsText(arquivo);
	}
	
	// Método de escrever o log:
	// Foi "herdado" da classe abstrata mãe LoggerWriter.

}
