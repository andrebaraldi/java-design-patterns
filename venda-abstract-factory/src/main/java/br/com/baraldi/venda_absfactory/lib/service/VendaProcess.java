package br.com.baraldi.venda_absfactory.lib.service;

import java.math.BigDecimal;

import br.com.baraldi.venda_absfactory.factory.ModuloVendaFactory;
import br.com.baraldi.venda_absfactory.lib.model.Boleta;
import br.com.baraldi.venda_absfactory.lib.model.Nfe;

public class VendaProcess {
	
	// Objects from needed Interfaces
	private static Nfe nfe;
	private static Boleta boleta;
	
	private static BigDecimal valorNota;
	
	// Do...
	public static boolean execute(ModuloVendaFactory vendaFactory, BigDecimal valorNota) {
		
		// Load...
		nfe = vendaFactory.criarNfe();
		boleta = vendaFactory.criarBoleta();
		
		// Execute...
		nfe.calcularImposto(valorNota);
		nfe.gerar();
		boleta.emitir();
		
		// Return...
		return true;		
	}	
}
