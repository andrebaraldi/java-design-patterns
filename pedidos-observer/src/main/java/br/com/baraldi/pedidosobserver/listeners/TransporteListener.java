package br.com.baraldi.pedidosobserver.listeners;

import br.com.baraldi.pedidosobserver.model.Pedido;
import br.com.baraldi.pedidosobserver.notifiers.Notifier;

public class TransporteListener implements Listener {

	// Our notifier
	private Notifier notifier;
	
	
	// Constructor : wait our notifier to register
	public TransporteListener(Notifier notifier) {
		this.notifier = notifier;
		this.notifier.registerListener(this);
	}
	
	
	@Override
	public void atualizar() {

		System.out.println("==================================================");
		System.out.println("Enviando o(s) produto(s) abaixo para os destinatário(s):");
		
		for (Pedido pedido : this.notifier.getPedidosList()) {
			System.out.println(pedido.toString());
		}		
	}

}
