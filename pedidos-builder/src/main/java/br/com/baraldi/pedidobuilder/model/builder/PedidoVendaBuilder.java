package br.com.baraldi.pedidobuilder.model.builder;

import java.math.BigDecimal;
import java.util.ArrayList;

import br.com.baraldi.pedidobuilder.model.Cliente;
import br.com.baraldi.pedidobuilder.model.ItemPedido;
import br.com.baraldi.pedidobuilder.model.PedidoVenda;


public class PedidoVendaBuilder {

    private PedidoVenda instance;
    
    public PedidoVendaBuilder() {
    	this.instance = new PedidoVenda();
    }
    
    
    // Cria um cliente
    // -------------------
    private void criaCliente(String nome, boolean vip) {
		// Cria o cliente
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setVip(vip);
		
		this.instance.setCliente(cliente);
    }
    
    // Seta cliente normal
    // -------------------
    public PedidoVendaBuilder setClienteNormal(String nome) {
	
		this.criaCliente(nome, false);
			
		// Retorna o Builder
		return this;
    }
    
    // Seta cliente Vip
    // -------------------
    public PedidoVendaBuilder setClienteVip(String nome) {
	
		this.criaCliente(nome, true);
			
		// Retorna o Builder
		return this;
    }
    
    
    // Item do Pedido
    // -------------------
    public PedidoVendaBuilder setItem(String nome, Integer qtde, String valorUnitario) {
	
		// Cria o item
		ItemPedido item = new ItemPedido();
		
		item.setNome(nome);
		item.setValorUnitario(new BigDecimal(valorUnitario));
		item.setQuantidade(qtde);
		
		
		// Valida se para esse pedido a lista de Item já foi criada antes
		if (this.instance.getItensPedido() == null) {
		    this.instance.setItensPedido( new ArrayList<ItemPedido>() );
		}
		
		// Adiciona o item no array de itens do Pedido
		this.instance.getItensPedido().add(item);
		
		// retorna o Builder
		return this;
	}
		    
	public PedidoVenda construir() {
	   	return this.instance;
    }
    
}
