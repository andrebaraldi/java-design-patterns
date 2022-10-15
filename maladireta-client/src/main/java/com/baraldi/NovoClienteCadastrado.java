package com.baraldi;

import java.time.format.DateTimeFormatter;

import com.baraldi.maladireta.MalaDireta;
import com.baraldi.maladireta.xml.ContatosXML;
import com.baraldi.maladireta.xml.MalaDiretaXML;

// Testa a execução da Classe via XML
public class NovoClienteCadastrado {

	public static void main(String[] args) {
		
		DateTimeFormatter date;
		
		ContatosXML  a = new ContatosXML("rte");
		
		String mensagem = "Novo Cliente cadastrado.";
		
		MalaDireta malaDireta = new MalaDiretaXML("contatos.xml");
		
		boolean status = malaDireta.enviarEmail(mensagem);
		
		System.out.println("Emails enviados? " + status);
		
	}

}
