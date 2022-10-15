package br.com.baraldi.pagamentoabsfac.gestorderisco.clearsale;

import java.math.BigDecimal;

import br.com.baraldi.pagamentoabsfac.gestorderisco.AlertaDeRiscoException;
import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;

public class ClearSale implements GestorDeRisco {

	
	// Evaluates the risk
	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		
		if (cartao.startsWith("1111") && valorMuitoAlto(valor)) {
			throw new AlertaDeRiscoException("Cartão muito alto para esse cartão.");
		}
    }
	
	private boolean valorMuitoAlto(BigDecimal valor) {
		
		BigDecimal limite = new BigDecimal("5000");
		
		return limite.compareTo(valor) < 0; 
	}
	

}
