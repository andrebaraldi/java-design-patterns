package br.com.baraldi.segurostrategy.model;

import br.com.baraldi.segurostrategy.calculo.CalculadoraPremioSeguro;
import br.com.baraldi.segurostrategy.calculo.carro.CalculadoraPremioSeguroCarro;
import br.com.baraldi.segurostrategy.calculo.moto.CalculadoraPremioSeguroMoto;

public enum TipoVeiculo {

	CARRO { 
			@Override
			public CalculadoraPremioSeguro getCalculadoraPremioSeguro() {
				return new CalculadoraPremioSeguroCarro();
			}
	},
	MOTO {
		
			@Override
			public CalculadoraPremioSeguro getCalculadoraPremioSeguro() {
				return new CalculadoraPremioSeguroMoto();
			}
		};
	
	public abstract CalculadoraPremioSeguro getCalculadoraPremioSeguro(); 
	
}
