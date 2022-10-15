package br.com.baraldi.logger.text;

import java.io.File;
import java.io.FileWriter;

import java.net.URI;
import java.net.URISyntaxException;

import br.com.baraldi.log.Logs;

// Escreve Logs em arquivos texto
public class LogsText implements Logs {

	// Nome do arquivo a imprimir
	private String fileName;
	
	// Construtor
	// ------------------------------------
	public LogsText(String fileName) {
		this.fileName = fileName;
	}
	
	
	// Implementa o método de Escrita
	// ------------------------------------
	@Override
	public void write(String logText)  {
	
	    // Caminho do Arquivo
	    try {
		
		 URI uri = this.getClass().getResource("/" + this.fileName).toURI();
		 System.out.println(uri);
		
		 // Abrindo o arquivo
		 File fileUri = new File(uri);
		 FileWriter fileWriter = new FileWriter(fileUri);
		 
		 fileWriter.append( this.getHour() + "......." + logText);
		 fileWriter.close();
		
	    }
	    catch (Exception e){
		System.out.println("Erro ao gravar Log do arquivo: " + e.getMessage() + e.getStackTrace());
	    }
		
	}

}
