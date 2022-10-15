package com.baraldi.maladireta;

import java.util.List;

import com.baraldi.contato.Contato;
import com.baraldi.contato.Contatos;

// Classe abstrata MalaDireta
// Envia uma mala direta a partir de uma lista de Contatos
// A criação/geração da lista de contatos poderá ser implementada
// pelas subClasses
public abstract class MalaDireta {
	
	// Método criarContatos deverá ser implementado pelas classes filhas 
	// Retorna um objeto do tipo Interface Contatos (que possui o método Contatos.todos() )
	protected abstract Contatos criarContatos();

	public boolean enviarEmail(String mensagem) {
		
		// Repositório que devolve a lista de contato
		List<Contato> contatos = criarContatos().todos();
		
		// Simulação de envio de email
		System.out.println("Conectando no servidor SMTP...");
		System.out.println("Mensagem a ser enviada: " + mensagem);
		System.out.println();
		
		for (Contato contato : contatos) {
			System.out.println("From: <contato@algaworks.com>");
			System.out.printf("To: [%s] <%s>\n", contato.getNome(), contato.getEmail());
			System.out.println(mensagem);
			System.out.println();
		}
		
		return true;
		
	}
	
}
