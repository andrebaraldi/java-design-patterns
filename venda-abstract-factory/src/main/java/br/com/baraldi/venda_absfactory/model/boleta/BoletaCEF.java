package br.com.baraldi.venda_absfactory.model.boleta;

import br.com.baraldi.venda_absfactory.lib.model.Boleta;

public class BoletaCEF implements Boleta{

	@Override
	public void emitir() {
		System.out.println("--------------------------------------------");
		System.out.println("Caixa Econômica Federal - Emissão de Boleto");	
		System.out.println("--------------------------------------------");	
	}
	
}
