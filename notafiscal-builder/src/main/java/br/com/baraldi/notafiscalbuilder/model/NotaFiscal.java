package br.com.baraldi.notafiscalbuilder.model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class NotaFiscal {

	/// Attributes
	private Integer numero;
	private Date dataEmissao ;
	private TipoPessoa tipoPessoa;
	private List<Produto> produtos;
	private BigDecimal valor;
	private BigDecimal valorImposto;

	
	// --------------------------
	// Get/Set
	// --------------------------
	public Integer getNumero() {
		return numero;
	}
	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
	// PF or PJ
	// --------------
	public TipoPessoa getTipoPessoa() {
		return tipoPessoa;
	}
	public void setTipoPessoa(TipoPessoa tipoPessoa) {
		this.tipoPessoa = tipoPessoa;
	}
	
	// Products
	public List<Produto> getProdutos() {
		return produtos;
	}
	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}
	
	// ---------------
	// Values
	// ---------------
	// Value of all Products
	public BigDecimal getValor() {
				
		if (! this.isEmpty() ) {
		
			// Using Stream with lambda (Java 8)
			this.setValor(BigDecimal.valueOf( this.produtos.stream()
								              .mapToDouble(p -> p.getValor().doubleValue() * p.getQuantidade())
								              .sum()								
					                          ));
		} else {
			this.setValor( BigDecimal.ZERO);
		}
		
		return this.valor;
	}	
	private void setValor(BigDecimal valor) {
		this.valor = valor;
	}	
	
	// Tax according Person Type	
	public BigDecimal getValorImposto() {
		
		this.setValorImposto ( BigDecimal.valueOf(this.getValor().doubleValue() * 
				                                  this.getTipoPessoa().getValorImposto()) );		
		return this.valorImposto;
	}	
	private void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}
	
	
	// ------------------------
	// Specific Methods
	// ------------------------
	// Validates if the Product's List is empty
	private boolean isEmpty() {
		return ( this.getProdutos() == null ? true : false ); 
	}
	

}
