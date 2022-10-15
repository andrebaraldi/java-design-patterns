package br.com.baraldi.cobrancadecorator.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

import br.com.baraldi.cobrancadecorator.model.CartaoCredito;
import br.com.baraldi.cobrancadecorator.model.Cliente;

public class AutorizadorCielo implements AutorizadorCartaoCredito {
	
	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) {
		
		
		try (PrintStream writer = new PrintStream(new FileOutputStream("debitos.txt", true))) {
		
			writer.println(cliente + " | " + cartaoCredito + " | R$" + valor);
		
		} catch (FileNotFoundException e) {
			
			throw new RuntimeException("Impossível salvar arquivo", e);
		}
	}

}