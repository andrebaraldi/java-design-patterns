package br.com.baraldi.pagamentoabsfac.gestorderisco.fcontrol;

import java.math.BigDecimal;
import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.gestorderisco.AlertaDeRiscoException;
 
public class FControl implements GestorDeRisco{

	// Evaluates the risk
	@Override
	public void avaliarRisco(String cartao, BigDecimal valor) throws AlertaDeRiscoException {
		
		if (cartao.startsWith("7777")) {
			throw new AlertaDeRiscoException("Cartão suspeito.");
		}
    }
	
}
