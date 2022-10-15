package br.com.baraldi.financeiroobserver.listeners;

import java.util.List;

import br.com.baraldi.financeiroobserver.model.Lancamento;
import br.com.baraldi.financeiroobserver.notifier.Notificador;

public class SMSListener implements Listener {
	
	// Somos um Listener e estamos registrando 
	// quem será nosso notificador
	private Notificador notificador;
	
	
	// Construtor
	// Já amarra com um notificador
	public SMSListener(Notificador notificador) {
		this.notificador = notificador;
		this.notificador.registrarListener(this);
	}
		
	
    @Override
    public void atualizar() {
    	
		for (Lancamento lancamento : this.notificador.getLancamentosVencidos()) {
			System.out.println("Enviando SMS para " + lancamento.getPessoa().getTelefone());
		}
		
		// Se caso, após processar, quiséssemos não ser mais um listener
		// do notificador
		//this.notificador.removerListener(this);
    }

}