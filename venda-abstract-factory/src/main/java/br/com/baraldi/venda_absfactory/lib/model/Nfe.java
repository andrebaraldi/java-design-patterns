package br.com.baraldi.venda_absfactory.lib.model;

import java.math.BigDecimal;

public interface Nfe {

	public void gerar();
	
	public void calcularImposto(BigDecimal valorNota);
}
