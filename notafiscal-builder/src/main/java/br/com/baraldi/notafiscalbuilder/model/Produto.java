package br.com.baraldi.notafiscalbuilder.model;

import java.math.BigDecimal;

public class Produto {

	// Attributes
	private String nome;
	private BigDecimal valor;
	private Integer quantidade;

	// Constructor
	public Produto(String nome, BigDecimal valor, int quantidade) {
		super();
		this.setNome(nome);
		this.setValor(valor);
		this.setQuantidade(quantidade);
	}
	
	// Get/Set
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public BigDecimal getValor() {
		return valor;
	}
	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}
}
