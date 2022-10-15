package br.com.baraldi.financeiroobserver.notifier;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import br.com.baraldi.financeiroobserver.listeners.Listener;
import br.com.baraldi.financeiroobserver.model.Lancamento;

public class NotificadorLancamentosVencidos implements Notificador {

	// Usamos Set (porque não precisa ser ordenado e nem podemos depender da ordem)
	private Set<Listener> listeners;
	
	private List<Lancamento> lancamentosVencidos;
	
	// Constructor...
	// ---------------------
	public NotificadorLancamentosVencidos() {
		// initialize a empty listener's set
		this.listeners = new HashSet();
	}
	
	@Override
	public void registrarListener(Listener listener) {
		this.listeners.add(listener);
	}

	@Override
	public void removerListener(Listener listener) {
		this.listeners.remove(listener);
		
	}

	@Override
	public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos) {
		this.lancamentosVencidos = lancamentosVencidos;
		// Chegou lançamentos? Vamos notificar nossos Listeners:
		this.notificarListeneres();
	}
	
	@Override
	public void notificarListeneres() {
		
		for (Listener listener : listeners) {
			listener.atualizar();
		}
	}

	@Override
	public List<Lancamento> getLancamentosVencidos() {
		return lancamentosVencidos;
	}

}
