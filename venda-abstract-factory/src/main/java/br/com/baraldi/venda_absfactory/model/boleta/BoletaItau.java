package br.com.baraldi.venda_absfactory.model.boleta;

import br.com.baraldi.venda_absfactory.lib.model.Boleta;

public class BoletaItau implements Boleta{

	@Override
	public void emitir() {
		System.out.println("----------------------------------");
		System.out.println("Banco Digital Itaú - Emissão de Boleto em PDF");	
		System.out.println("----------------------------------");	
	}
	
}
