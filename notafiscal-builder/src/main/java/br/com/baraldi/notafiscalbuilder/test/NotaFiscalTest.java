package br.com.baraldi.notafiscalbuilder.test;

import static org.junit.Assert.assertEquals;

import java.text.SimpleDateFormat;

import org.junit.Test;

import br.com.baraldi.notafiscalbuilder.model.NotaFiscal;
import br.com.baraldi.notafiscalbuilder.model.TipoPessoa;
import br.com.baraldi.notafiscalbuilder.model.builder.NotaFiscalBuilder;

public class NotaFiscalTest {

	
	// Simple Creation
	// ----------------------
	@Test
	public void deveCriarUmaNotaFiscalZerada() throws Exception {
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder().build();
		
		assertEquals(notaFiscal.getValor().doubleValue(), 0, 0.0001);
	}
	
	
	@Test
	public void deveCriarUmaNotaFiscalImpostoZero() throws Exception {
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder().setTipoPessoa(TipoPessoa.PF).build();
		
		assertEquals(notaFiscal.getValorImposto().doubleValue(), 0, 0.0001);
	}
	
	
	// Calculate fee for PJ
	// ----------------------
	@Test 
	public void deveCalcularImpostoParaPJ() throws Exception {
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
				                             .setTipoPessoa(TipoPessoa.PJ)
				                             .setProduto("Guitarra", 100.00, 1)
				                             
				                             .build();
		
		assertEquals(notaFiscal.getValorImposto().doubleValue(), 7.0d, 0.001  );
		
	}
	
	// Calculate fee for PF
	// ----------------------
	@Test 
	public void deveCalcularImpostoParaPF() throws Exception {
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
				                             .setTipoPessoa(TipoPessoa.PF)
				                             .setProduto("Guitarra", 100.00, 1)
				                             
				                             .build();
		
		assertEquals(notaFiscal.getValorImposto().doubleValue(), 4.0d, 0.001  );
		
	}
	
	// Testing overloading
	// ----------------------
	@Test
	public void permiteCriarNotaComDataDeEmissaoEmDate() throws Exception{
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
											.setTipoPessoa(TipoPessoa.PF)
											.setProduto("Pedal", 500d, 2)
											.setDataEmissao(new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2022"))
											.build();
		
		assertEquals(notaFiscal.getDataEmissao(), new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2022"));
	}
	
	@Test
	public void permiteCriarNotaComDataDeEmissaoEmString() throws Exception{
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
											.setTipoPessoa(TipoPessoa.PF)
											.setProduto("Pedal", 500d, 2)
											.setDataEmissao("01/09/2022")
											.build();
		
		assertEquals(notaFiscal.getDataEmissao(), new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2022"));
	}
	
	@Test
	public void permiteCriarProdutoComValorEmString() throws Exception {
		
		NotaFiscal notaFiscal = new NotaFiscalBuilder()
											.setTipoPessoa(TipoPessoa.PF)
											.setProduto("Pedal", "600", 2)
											.setDataEmissao("01/09/2022")
											.build();
		
		
		assertEquals(notaFiscal.getValor().doubleValue(), 1200d, 0.001);
	}
}
