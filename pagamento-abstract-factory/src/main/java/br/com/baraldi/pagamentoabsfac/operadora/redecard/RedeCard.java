package br.com.baraldi.pagamentoabsfac.operadora.redecard;

import java.math.BigDecimal;

import br.com.baraldi.pagamentoabsfac.operadora.CapturaNaoAutorizadaException;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;

public class RedeCard implements Operadora{
	
	private Long codigoConfirmacao = -1L;

	// -------------------------------------------------
	// Simulates a validation on Card and value
	// -------------------------------------------------
	@Override
	public void capturar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException {
		
		if (cartao.startsWith("222") && valorMaiorQueLimite(valor)) {
			throw new CapturaNaoAutorizadaException("Valor maior que limite para cartão informado!");
		}
		
		this.codigoConfirmacao = (long) Math.random() * 300;
	}
	
	// -------------------------------------------------
	// Simulates a confirmation to the Card
	// -------------------------------------------------
	@Override
	public Long confirmar() {
		
		System.out.println("Efetuando o débito na conta do cliente via RedeCard");
		return this.codigoConfirmacao;
	}
	
	
	public boolean valorMaiorQueLimite(BigDecimal valor) {
		
		BigDecimal limite = new BigDecimal("1000");
		return valor.compareTo(limite) > 0;
		
	}
}
