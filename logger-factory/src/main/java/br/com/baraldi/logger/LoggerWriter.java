package br.com.baraldi.logger;

import br.com.baraldi.log.Logs;

//--------------------------------------------
// Classe abstrata para geração de Log
// --------------------------------------------
public abstract class LoggerWriter {
	
	// Método abstrato que deverá ser implementado pelas classes filhas
	// Retorna um objeto do tipo da interface Logs, que possui o método write()
	// O método write() do objeto retornado será a especialização de onde será feito o Log
	protected abstract Logs getLogger();
	
	// Todas as classes filhas receberão esse método de graça
	public void geraLog(String mensagem) {
	
		// Escreve o Log
		getLogger().write(mensagem);
	}
	
}
