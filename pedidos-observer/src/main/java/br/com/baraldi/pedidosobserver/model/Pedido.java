package br.com.baraldi.pedidosobserver.model;

public class Pedido {

	private String descricao;
	private double valor;
	
	
	public Pedido(String descricao, double valor) {
		super();
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	
	@Override
	public String toString() {
		
		StringBuilder info = new StringBuilder();
		
		info.append("Produto...: " + this.getDescricao())
		    .append("\nValor....: " + this.getValor());
		
		return info.toString();
	}
}
