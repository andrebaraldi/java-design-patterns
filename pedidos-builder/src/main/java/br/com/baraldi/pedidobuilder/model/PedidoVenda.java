package br.com.baraldi.pedidobuilder.model;

import java.math.BigDecimal;
import java.util.List;

public class PedidoVenda {

    // Atributos
    private String numero;
	private Cliente cliente;
	private List<ItemPedido> itensPedido;

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemPedido> getItensPedido() {
		return itensPedido;
	}

	public void setItensPedido(List<ItemPedido> itensPedido) {
		this.itensPedido = itensPedido;
	}

	// Retorna o valor total do Pedido
	public BigDecimal getValorTotal() {
	    
	    // Inicializa o valor Total
	    BigDecimal valorTotal = BigDecimal.ZERO;
	    
	    // Varre os pedidos e calcula o valor de cada item * quantidade
	    for (ItemPedido item : itensPedido) {
	    	valorTotal = valorTotal.add(item.getValorUnitario().multiply(new BigDecimal(item.getQuantidade())));
	    }
		
	    // Se cliente vip dar 4% de desconto
	    if (this.getCliente().isVip()) {
	    	valorTotal = valorTotal.multiply(new BigDecimal("0.96"));
	    }
		
	    return valorTotal;
	}
}
