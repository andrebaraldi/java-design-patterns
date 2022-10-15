package br.com.baraldi.segurostrategy.calculo.moto;

import br.com.baraldi.segurostrategy.calculo.CalculadoraPremioSeguro;
import br.com.baraldi.segurostrategy.model.Cliente;


public class CalculadoraPremioSeguroMoto implements CalculadoraPremioSeguro {
	
	public double calcularCliente(Cliente cliente, double valorMoto) {

		double taxa;
		
		if ( cliente.getIdade() >= 18 && cliente.getIdade() <= 30 ) { 
			taxa = 0.05;
		} else {
			taxa = 0.045;
		} 
		
		return valorMoto * taxa;
	}

}
