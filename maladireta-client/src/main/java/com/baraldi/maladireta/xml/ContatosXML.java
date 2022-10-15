package com.baraldi.maladireta.xml;

import java.net.URL;
import java.util.List;

import com.baraldi.contato.Contato;
import com.baraldi.contato.Contatos;
import com.thoughtworks.xstream.XStream;

public class ContatosXML implements Contatos {

	// Nome do Arquivo
	private String nomeArquivo;
	
	// No construtor receberemos o nome do arquivo
	// ------------------------------------------------------------------------
	public ContatosXML(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
	
	// ------------------------------------------------------------------------
	// Método da interface Contatos que deve ser implementada
	// Esse método retornará um List<Contato> a partir de um arquivo CSV
	// ------------------------------------------------------------------------
	@SuppressWarnings("unchecked")
	@Override
	public List<Contato> todos() {
		
		// Instancia objeto XML
		//XStream xStream = new XStream();
				
		// Informa a primeira chave
		//xStream.alias("contatos", List.class);
		// Informa as chaves dentro da primeira chave
		//xStream.alias("contato", Contato.class);
		
		// Aponta para o arquivo em resources
		//URL arquivo = this.getClass().getResource("/" + nomeArquivo);
		
		// Retorna uma lista de contatos do arquivo XML
		// Repare que efetuamos Casting
		//return (List<Contato>) xStream.fromXML(arquivo);
		
		
		XStream xstream = new XStream();
	    xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
	    URL arquivo = this.getClass().getResource("/" + nomeArquivo);
	    return (List<Contato>) xstream.fromXML(arquivo);		
		
	}
}
