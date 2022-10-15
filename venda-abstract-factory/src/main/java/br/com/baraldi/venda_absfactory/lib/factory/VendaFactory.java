package br.com.baraldi.venda_absfactory.lib.factory;

import br.com.baraldi.venda_absfactory.lib.model.Boleta;
import br.com.baraldi.venda_absfactory.lib.model.Nfe;

// Fábrica de objetos necessário para a Venda
public abstract class VendaFactory {

	public abstract Nfe criarNfe();	
	public abstract Boleta criarBoleta();
	
}
