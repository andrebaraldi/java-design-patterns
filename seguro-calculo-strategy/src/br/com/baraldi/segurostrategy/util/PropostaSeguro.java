package br.com.baraldi.segurostrategy.util;

import br.com.baraldi.segurostrategy.calculo.CalculadoraPremioSeguro;
import br.com.baraldi.segurostrategy.model.Cliente;


public class PropostaSeguro {

	private Cliente cliente;
	private CalculadoraPremioSeguro calculadora;
	
	
	public PropostaSeguro(Cliente cliente) {
		this.cliente = cliente;
	}
	
	
	public String gerar(double valorVeiculo) {
		
		StringBuilder proposta = new StringBuilder();
		
		proposta.append("\n================================================")
			    .append("\nProposta de Seguro\n")
			    .append("\nCliente: " + this.cliente.getNome())
			    .append("\nIdade: " + this.cliente.getIdade())
			    .append("\nSexo: " + this.cliente.getSexo().getDescricao())
			    .append("\nValor do Seguro : " + Math.round(calculadora.calcularCliente(cliente, valorVeiculo)))
			    .append("\n================================================")
			    ;
		
		return proposta.toString();
	}
	
	
	public void setCalculadora(CalculadoraPremioSeguro calculadora) {
		this.calculadora = calculadora;
	}
	
}
