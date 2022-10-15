package br.com.baraldi.cobrancadecorator.service;

import java.time.YearMonth;

import br.com.baraldi.cobrancadecorator.exception.RiscoCreditoException;
import br.com.baraldi.cobrancadecorator.model.CartaoCredito;
import br.com.baraldi.cobrancadecorator.model.Cliente;


public class AnalisadorDeRiscoClearSale implements AutorizadorCartaoCredito {

    private AutorizadorCartaoCredito autorizador;
    
    // Construtor recebendo AutorizadorCartaoCredito
    public AnalisadorDeRiscoClearSale(AutorizadorCartaoCredito autorizador) {
		this.autorizador = autorizador;
	}
    
	
	@Override
	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) throws RiscoCreditoException  {
		
		// Adicionar funcionalidades antes
		if (cliente.getCpf().startsWith("111") || 
				 cartaoCredito.getVencimento().isBefore(YearMonth.now()) || 
				 valor > 500) {
			
			throw new RiscoCreditoException("Crédito Negado");			
		}
		
		// Ao autorizar, vamos na outra classe que implementa AutorizadorCartaoCredito
		this.autorizador.autorizar(cliente, cartaoCredito, valor);
		
		// Adicionar funcionalidades depois (se necessário)
	}

	
}
