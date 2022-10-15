package br.com.baraldi.logger.screen;

// From logger-factory
import br.com.baraldi.log.Logs;
import br.com.baraldi.logger.LoggerWriter;


// Classe geradora do Log em Tela
import br.com.baraldi.logger.screen.LogsScreen;


public class LoggerWriterScreen extends LoggerWriter {

	// Informa/amarra qual o tipo de Log a ser gerado
	// No caso, é log em Tela
	@Override
	protected Logs getLogger() {
		return new LogsScreen();
	}
	

	// Método de escrever o log:
	// Vem "herdado" da classe abstrata mãe LoggerWriter.
	
}
