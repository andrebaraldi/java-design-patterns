package br.com.baraldi.segurostrategy.calculo;

import br.com.baraldi.segurostrategy.model.Cliente;

public interface CalculadoraPremioSeguro {

		public double calcularCliente(Cliente cliente, double valorVeiculo);	
}
