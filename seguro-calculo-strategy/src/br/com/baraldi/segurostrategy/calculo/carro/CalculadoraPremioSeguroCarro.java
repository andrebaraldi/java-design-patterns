package br.com.baraldi.segurostrategy.calculo.carro;

import br.com.baraldi.segurostrategy.calculo.CalculadoraPremioSeguro;
import br.com.baraldi.segurostrategy.model.Cliente;


public class CalculadoraPremioSeguroCarro implements CalculadoraPremioSeguro {

	public double calcularCliente(Cliente cliente, double valorVeiculo) { 

		return (cliente.getIdade() >= 50) ? valorVeiculo * 0.04 : valorVeiculo * 0.03;
	}

}
