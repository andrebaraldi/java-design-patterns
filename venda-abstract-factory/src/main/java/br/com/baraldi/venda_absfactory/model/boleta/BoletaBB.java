package br.com.baraldi.venda_absfactory.model.boleta;

import br.com.baraldi.venda_absfactory.lib.model.Boleta;

public class BoletaBB implements Boleta{

	@Override
	public void emitir() {
		System.out.println("----------------------------------");
		System.out.println("Banco do Brasil - Emissão de Boleto");	
		System.out.println("----------------------------------");	
	}
	

}
