package br.com.baraldi.contatos.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import br.com.baraldi.contatos.repository.Contatos;

public class ContatosXMLTest {

	@Test
	public void deveRetornarContato() {
		
		// Usando a Clase Proxy...
		// Contatos contatos = new ContatosXML("contatos1.xml", "contatos2.xml");
		Contatos contatos = new ContatosXMLProxy("contatos1.xml", "contatos2.xml");
	 
	    String nome = contatos.buscarPor("mauricio@email.com");
		assertEquals("Mauricio Ricardo", nome);
	}
	
}
