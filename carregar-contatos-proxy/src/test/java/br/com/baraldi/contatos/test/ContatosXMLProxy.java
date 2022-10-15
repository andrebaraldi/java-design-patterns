package br.com.baraldi.contatos.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import br.com.baraldi.contatos.repository.Contatos;
import br.com.baraldi.contatos.xml.ContatosXML;

public class ContatosXMLProxy implements Contatos {

	private ContatosXML contatosXML;
	private List<String> nomesArquivos;
	
	// Constructor
	// ----------------
	public ContatosXMLProxy(String... nomesArquivos) {
		this.nomesArquivos = new ArrayList<>(Arrays.asList(nomesArquivos));
	}
	
	// From Contatos interface
	// ------------------------
	@Override
	public String buscarPor(String email) {
		
		// The return
		String nome = null;
		
		// Número aleatório para buscarmos arquivo por arquivo
		Random random = new Random();
		
		// Se temos 5 arquivos, o indice para pesquisa poderá ser algo de 0 a 4
		int quantidadeArquivos = nomesArquivos.size();
		
		// Looping: reading and remove files from list
		for (int i = 0; i < quantidadeArquivos; i++) {
			
			// Next file inside of the List...
			int indiceParaPesquisa = random.nextInt(nomesArquivos.size());
			
			// O método remove retorna o item que estamos retirando da lista
			String nomeArquivo = nomesArquivos.remove(indiceParaPesquisa);
			
			// Tenta buscar o nome, somente com um único arquivo
			this.contatosXML = new ContatosXML(nomeArquivo);
			nome = this.contatosXML.buscarPor(email);
			
			if (nome != null) break;
		}
		
		return nome;
	}

}
