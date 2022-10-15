package br.com.baraldi.pagamentoabsfac.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.baraldi.pagamentoabsfac.gestorderisco.AlertaDeRiscoException;
import br.com.baraldi.pagamentoabsfac.operadora.CapturaNaoAutorizadaException;
import br.com.baraldi.pagamentoabsfac.pagamento.ModuloPagamentoFactory;
import br.com.baraldi.pagamentoabsfac.pagamento.Pagamento;
import br.com.baraldi.pagamentoabsfac.pagamento.pagseguro.PagSeguroModuloPagamentoFactory;

public class PagamentoPagSeguroTest {

	private Pagamento pagamento;
	
	@Before
	public void init() {
		
		// Fábrica dos objetos necessários para a Cielo
		ModuloPagamentoFactory moduloPagamentoFactory = new PagSeguroModuloPagamentoFactory();
		
		// Envia os objetos Cielo para pagamento efetuar o pagamento
		pagamento = new Pagamento(moduloPagamentoFactory);
	}
	
	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		Long codigoAutorizacao = pagamento.autorizar("2222.2222", new BigDecimal("200"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test(expected=CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_cartaoInvalido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("5555.2222", new BigDecimal("2000"));
	}
	
	@Test(expected=AlertaDeRiscoException.class)
	public void deveGerarAlertaDeRisco() throws CapturaNaoAutorizadaException, AlertaDeRiscoException {
		pagamento.autorizar("7777.2222", new BigDecimal("5500"));
	}
	
	
}
