package br.com.baraldi.venda_absfactory.model;

import java.math.BigDecimal;

public enum Estados {

	SP("São Paulo", BigDecimal.valueOf(0.10)),
	RJ("Rio de Janeiro", BigDecimal.valueOf(0.07)),
	PE("Pernambuco", BigDecimal.valueOf(0.06));
	
	private String nome;
	private BigDecimal imposto;
	
	private Estados(String estado, BigDecimal imposto) {
		this.setNome(estado);
		this.setImposto(imposto);
	}

	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public BigDecimal getImposto() {
		return imposto;
	}
	public void setImposto(BigDecimal imposto) {
		this.imposto = imposto;
	}
	
}
