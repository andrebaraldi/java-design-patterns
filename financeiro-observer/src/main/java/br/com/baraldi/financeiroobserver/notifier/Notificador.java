package br.com.baraldi.financeiroobserver.notifier;

import java.util.List;

import br.com.baraldi.financeiroobserver.listeners.Listener;
import br.com.baraldi.financeiroobserver.model.Lancamento;

public interface Notificador {
	
	public void registrarListener(Listener listener);
	
	public void removerListener(Listener listener);
	
	public void novosLancamentosVencidos(List<Lancamento> lancamentosVencidos);
		
	public void notificarListeneres();
	
	public List<Lancamento> getLancamentosVencidos();

}
