package br.com.baraldi.pagamentoabsfac.pagamento;

import java.math.BigDecimal;

import br.com.baraldi.pagamentoabsfac.gestorderisco.AlertaDeRiscoException;
import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.gestorderisco.fcontrol.FControl;
import br.com.baraldi.pagamentoabsfac.operadora.CapturaNaoAutorizadaException;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;

public class Pagamento {

	// Operator and risk evaluator
	private Operadora operadora;
	private GestorDeRisco gestorDeRisco;
	
	
	// Constructor - Recebe a fábrica de Objetos de pagamento
	// ---------------------------------------------------------------------	
	public Pagamento(ModuloPagamentoFactory moduloPagamentoFactory) {		
		this.operadora = moduloPagamentoFactory.criaOperadora();
		this.gestorDeRisco = moduloPagamentoFactory.criarGestorDeRisco();
	}
	
	// Receives Card and Value to approve
	// ---------------------------------------	
	public Long autorizar(String cartao, BigDecimal valor) throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		
		// Reserves the value on Card Operator
		this.operadora.capturar(cartao, valor);
		
		// Be sure about the value of shopping 
		this.gestorDeRisco.avaliarRisco(cartao, valor);
		
		// Confirm the shopping
		return this.operadora.confirmar();
    }
	
}
