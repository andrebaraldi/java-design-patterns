package com.baraldi.maladireta.csv;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import com.baraldi.contato.Contato;
import com.baraldi.contato.Contatos;

import au.com.bytecode.opencsv.CSVReader;

// Classe CSV que implementa a interface Contatos da bilioteca
// maladireta-factory
public class ContatosCSV implements Contatos{	
	
	// Nome do Arquivo
	private String nomeArquivo;
	
	// No construtor receberemos o nome do arquivo
	// ------------------------------------------------------------------------
	public ContatosCSV(String nomeArquivo) {
		this.nomeArquivo = nomeArquivo;
	}
		
	// ------------------------------------------------------------------------
	// Método da interface Contatos que deve ser implementada
	// Esse método retornará um List<Contato> a partir de um arquivo CSV
	// ------------------------------------------------------------------------
	@Override
	public List<Contato> todos() {		

		// Objeto a retornar 
		List<Contato> contatos = new ArrayList<>();
		
		// Leitor de CSV
		CSVReader csvReader = null;
		
		try {
			// Aponta para o nome do arquivo na pasta Resources
			URI uri = this.getClass().getResource("/" + nomeArquivo).toURI();
			
			// Abre o arquivo
			File arquivoCsv = new File(uri);
			FileReader fileReader = new FileReader(arquivoCsv);
			
			// Cria uma instancia de arquivo CSV
			csvReader = new CSVReader(fileReader);
			
			// Cria um vetor de String para leitura do CSV
		    String[] nextLine;
		    
		    // Leitura do CSV, adicionando no List de contato
		    while ((nextLine = csvReader.readNext()) != null) {
		    	contatos.add(new Contato(nextLine[0].trim(), nextLine[1].trim()));
		    }
		    
		} catch (Exception e) {
			throw new RuntimeException("Erro lendo arquivo csv", e);
		} finally {
			try {
	            csvReader.close();
            } catch (IOException e) { }
		}
		
		return contatos;
	}

}
