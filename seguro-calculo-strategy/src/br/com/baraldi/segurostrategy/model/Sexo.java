package br.com.baraldi.segurostrategy.model;

public enum Sexo {
	
	M("Masculino"),
	F("Feminino"),
	O("Outro");
	
	final private String descricao;
	
	private Sexo(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
