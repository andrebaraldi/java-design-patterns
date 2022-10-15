package com.baraldi.maladireta.xml;

import com.baraldi.contato.Contatos;
import com.baraldi.maladireta.MalaDireta;
import com.baraldi.maladireta.csv.ContatosCSV;

public class MalaDiretaXML extends MalaDireta {

	// Nome do Arquivo da malaDireta de XML
	private String nomeArquivo;
	
	public MalaDiretaXML(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
		
	// Método que deve ser implementado pelas filhas da abstrata MalaDireta
	@Override
	protected Contatos criarContatos() {
		// Retorna um objeto que implementa a interface Contatos (maladireta-factory)
		return new ContatosXML(nomeArquivo);
	}
	
	// Método de Enviar e-mail:
	// Recebemos de graça da classe mãe MalaDireta

}
