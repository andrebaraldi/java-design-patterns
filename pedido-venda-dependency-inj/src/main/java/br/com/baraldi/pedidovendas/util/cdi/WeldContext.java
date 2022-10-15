package br.com.baraldi.pedidovendas.util.cdi;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;


public class WeldContext {

	public static final WeldContext INSTANCE = new WeldContext();
	
	private final Weld weld;
	private final WeldContainer container;
	
	
	// Construtor 
	// Inicializa o Weld e seu container
	private WeldContext() {
		this.weld = new Weld();
		this.container = weld.initialize();		
	}
	
	// GetBean
	// Recebe uma classe (Generics)
	public <T> T getBean(Class<T> type) {
		
		// Cria o objeto recebido
		return container.instance().select(type).get();
	}
	
}
