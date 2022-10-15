package br.com.baraldi.pedidosobserver.listeners;

import br.com.baraldi.pedidosobserver.model.Pedido;
import br.com.baraldi.pedidosobserver.notifiers.Notifier;

public class FaturamentoListener implements Listener {

	// Our notifier
	private Notifier notifier;
	
	
	// Constructor : wait our notifier to register
	public FaturamentoListener(Notifier notifier) {
		this.notifier = notifier;
		this.notifier.registerListener(this);
	}
	
	
	@Override
	public void atualizar() {
		
		System.out.println("==================================================");
		System.out.println("Solicitado faturamento para o(s) produto(s):");
				
		for (Pedido pedido : this.notifier.getPedidosList()) {
			System.out.println(pedido.toString());
		}		
	}

}
