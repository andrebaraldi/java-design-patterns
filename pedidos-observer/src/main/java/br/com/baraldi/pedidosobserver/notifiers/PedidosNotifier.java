package br.com.baraldi.pedidosobserver.notifiers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.baraldi.pedidosobserver.listeners.Listener;
import br.com.baraldi.pedidosobserver.model.Pedido;


public class PedidosNotifier implements Notifier {

	// Usamos Set (porque não precisa ser ordenado e nem podemos depender da ordem)
	private Set<Listener> listeners;
		
	private List<Pedido> novosPedidos;
	
	
	// Constructor...
	// ---------------------
	public PedidosNotifier() {
		this.listeners = new HashSet();		// initialize a empty listener's set
	}
	
	
	@Override
	public void registerListener(Listener listener) {		
		this.listeners.add(listener);
	}

	@Override
	public void removeListener(Listener listener) { 		
		this.listeners.remove(listener);
	}

	@Override
	public void notifyListeners() {
		for (Listener listener : this.listeners) {
			listener.atualizar();
		}
	}

	@Override
	public void addNewPedidosList(List<Pedido> novosPedidos) {
		
		this.novosPedidos = novosPedidos;
		this.notifyListeners();
	}

	@Override
	public List<Pedido> getPedidosList() {
		return this.novosPedidos;		
	}

}
