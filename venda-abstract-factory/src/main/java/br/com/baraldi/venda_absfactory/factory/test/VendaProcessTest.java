package br.com.baraldi.venda_absfactory.factory.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;
import br.com.baraldi.venda_absfactory.factory.ModuloVendaFactory;
import br.com.baraldi.venda_absfactory.lib.service.VendaProcess;

public class VendaProcessTest {
	
	@Test
	public void deveProcessarVenda() {
		
		ModuloVendaFactory moduloVendaFactory = new ModuloVendaFactory();
		
		boolean vendaOK = VendaProcess.execute(moduloVendaFactory, BigDecimal.valueOf(100 )) ;
		
		assertEquals(vendaOK, true);		
	}

}
