package br.com.baraldi.pagamentoabsfac.operadora.cielo;

import java.math.BigDecimal;

import br.com.baraldi.pagamentoabsfac.operadora.CapturaNaoAutorizadaException;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;

public class Cielo implements Operadora{

	private Long codigoConfirmacao = -1L;

	// -------------------------------------------------
	// Simulates a validation on Card and value
	// -------------------------------------------------
	@Override
	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
		
		if (cartao.startsWith("5555")) {
			throw new CapturaNaoAutorizadaException("Número de cartão inválido!");
		}
		
		this.codigoConfirmacao = (long) Math.random() * 1000;
	}
	
	// -------------------------------------------------
	// Simulates a confirmation to the Card
	// -------------------------------------------------
	@Override
	public Long confirmar() {
		
		System.out.println("Fazendo o débito na conta do cliente via Cielo");
		return this.codigoConfirmacao;
	}

	
}
