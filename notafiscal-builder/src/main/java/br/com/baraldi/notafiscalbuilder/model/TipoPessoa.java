package br.com.baraldi.notafiscalbuilder.model;

public enum TipoPessoa {

	PF(0.04f), 
	PJ(0.07f); 
	
	private final float valorImposto;
	
	private TipoPessoa(float valorImposto) {
		this.valorImposto = valorImposto;
	}

	public float getValorImposto() {
		return valorImposto;
	}
	
}
