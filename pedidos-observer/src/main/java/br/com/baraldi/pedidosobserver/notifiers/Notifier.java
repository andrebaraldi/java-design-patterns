package br.com.baraldi.pedidosobserver.notifiers;

import java.util.List;

import br.com.baraldi.pedidosobserver.listeners.Listener;
import br.com.baraldi.pedidosobserver.model.Pedido;


public interface Notifier {
	
	public void registerListener(Listener listener);
	public void removeListener(Listener listener);
	public void notifyListeners();
	
	public void addNewPedidosList(List<Pedido> novosPedidos);
	public List<Pedido> getPedidosList();
	
}
