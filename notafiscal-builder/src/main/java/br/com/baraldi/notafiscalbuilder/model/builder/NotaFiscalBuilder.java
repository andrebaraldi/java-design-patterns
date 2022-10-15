package br.com.baraldi.notafiscalbuilder.model.builder;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import br.com.baraldi.notafiscalbuilder.model.NotaFiscal;
import br.com.baraldi.notafiscalbuilder.model.Produto;
import br.com.baraldi.notafiscalbuilder.model.TipoPessoa;

public class NotaFiscalBuilder {

	// Attach a NotaFiscal
	private NotaFiscal notaFiscal;
	
	// Builder constructor
	public NotaFiscalBuilder() {
		this.notaFiscal = new NotaFiscal();
		
		// Initialize the Product's List
		this.notaFiscal.setProdutos( new ArrayList<Produto>() );
	}
	
	// --------------------------
	// Setting attributes
	// --------------------------
	public NotaFiscalBuilder setNumero(Integer numero) {		
		this.notaFiscal.setNumero(numero);		
		return this;
	}
	
	public NotaFiscalBuilder setDataEmissao(Date dataEmissao) {		
		this.notaFiscal.setDataEmissao(dataEmissao);		
		return this;
	}
	// Overloading setDataEmissao method with String type to attribute dataEmissao
	public NotaFiscalBuilder setDataEmissao(String dataEmissao) throws ParseException {				
		this.notaFiscal.setDataEmissao( new SimpleDateFormat("dd/MM/yyyy").parse(dataEmissao) );		
		return this;
	}	
	
	public NotaFiscalBuilder setTipoPessoa(TipoPessoa tipoPessoa) {		
		this.notaFiscal.setTipoPessoa(tipoPessoa);		
		return this;
	}
	
	// ---------------------------
	// Products Methods
	// ---------------------------	
	// Add a Product to NotaFiscal
	public NotaFiscalBuilder setProduto(String nome, BigDecimal valor, Integer quantidade) {
				
		// Creates and add the product to the list
		this.notaFiscal.getProdutos().add( new Produto(nome, valor, quantidade) );
		
		// Returns the Builder
		return this;
		
	} 
	// Add a Product to NotaFiscal - Overloading: accepts type String to attribute valor
	public NotaFiscalBuilder setProduto(String nome, String valor, Integer quantidade) {
				
		// Creates and add the product to the list
		this.notaFiscal.getProdutos().add( new Produto(nome, BigDecimal.valueOf(Double.parseDouble(valor)) , quantidade) );
		
		// Returns the Builder
		return this;
		
	} 
	// Add a Product to NotaFiscal
	public NotaFiscalBuilder setProduto(String nome, Double valor, Integer quantidade) {
				
		// Creates and add the product to the list
		this.notaFiscal.getProdutos().add( new Produto(nome, BigDecimal.valueOf(valor) , quantidade) );
		
		// Returns the Builder
		return this;
		
	} 
	
	
	
	// Build...
	public NotaFiscal build() {
		return this.notaFiscal;
	}
	
}
