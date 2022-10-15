package br.com.baraldi.pagamentoabsfac.test;

import static org.junit.Assert.assertNotNull;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import br.com.baraldi.pagamentoabsfac.gestorderisco.AlertaDeRiscoException;
import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.gestorderisco.clearsale.ClearSale;
import br.com.baraldi.pagamentoabsfac.operadora.CapturaNaoAutorizadaException;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;
import br.com.baraldi.pagamentoabsfac.operadora.redecard.RedeCard;
import br.com.baraldi.pagamentoabsfac.pagamento.Pagamento;
import br.com.baraldi.pagamentoabsfac.pagamento.paypal.PayPalModuloPagamentoFactory;

public class PagamentoViaPayPalTest {
	
	private Pagamento pagamento;
	
	@Before
	public void init() {
		pagamento = new Pagamento( new PayPalModuloPagamentoFactory() );		
	}
	

	@Test
	public void deveAutorizarVenda() throws CapturaNaoAutorizadaException, AlertaDeRiscoException{
		
		Long codigoAutorizacao = pagamento.autorizar("222.222", new BigDecimal("200"));
		
		assertNotNull(codigoAutorizacao);
	}

	@Test (expected = CapturaNaoAutorizadaException.class)
	public void deveNegarCaptura_valorAcimaDoLimiteParaCartao() throws CapturaNaoAutorizadaException, AlertaDeRiscoException{
		
		pagamento.autorizar("222.222", new BigDecimal("2000"));		
	}	
	
	@Test
	public void deveAutorizarVenda_valorAltoComCartaoValido() throws CapturaNaoAutorizadaException, AlertaDeRiscoException{
		
		Long codigoAutorizacao = pagamento.autorizar("3333.2222", new BigDecimal("2000"));
		assertNotNull(codigoAutorizacao);
	}
	
	@Test (expected = AlertaDeRiscoException.class)
	public void deveGerarAlertaDeRisco() throws  CapturaNaoAutorizadaException, AlertaDeRiscoException{
		
		pagamento.autorizar("1111.2222", new BigDecimal("5500") );
	}
	
	
	
}
