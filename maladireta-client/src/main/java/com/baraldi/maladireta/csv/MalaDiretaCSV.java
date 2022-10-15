package com.baraldi.maladireta.csv;

import com.baraldi.contato.Contatos;
import com.baraldi.maladireta.MalaDireta;

// Extendemos a classe abstrata malaDireta a partir de maladireta-factory
public class MalaDiretaCSV extends MalaDireta {

	// Nome do Arquivo da malaDireta de CSV
	private String nomeArquivo;
	
	public MalaDiretaCSV(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	
	// Método que deve ser implementado pelas filhas da abstrata MalaDireta
	@Override
	protected Contatos criarContatos() {
		// Retorna um objeto que implementa a interface Contatos (maladireta-factory)
		return new ContatosCSV(nomeArquivo);
	}

	// Método de Enviar e-mail:
	// Recebemos de graça da classe mãe MalaDireta
	
}
