package br.com.baraldi.venda_absfactory.factory;

import java.io.IOException;
import java.util.Properties;

import br.com.baraldi.venda_absfactory.lib.factory.VendaFactory;
import br.com.baraldi.venda_absfactory.lib.model.Boleta;
import br.com.baraldi.venda_absfactory.lib.model.Nfe;
import br.com.baraldi.venda_absfactory.model.boleta.BoletaCEF;
       

public class ModuloVendaFactory extends VendaFactory {
	
	// Objects to VendaProcess executing
	private Nfe nfe;
	private Boleta boleta;
	
	// ----------------------------------------------------------------
	// Construtor - Building Objects to VendaProcess executing 
	//              according file config.properties
	// ----------------------------------------------------------------
	public ModuloVendaFactory() {
		
        Properties properties = new Properties();
		
		try {
			properties.load(this.getClass().getResourceAsStream("/config.properties"));
			
			String classeNfe = properties.getProperty("nfe");			
			nfe = (Nfe) Class.forName(classeNfe).newInstance();
			
			String classeBoleta = properties.getProperty("boleta");			
			boleta = (Boleta) Class.forName(classeBoleta).newInstance();
			
				
		} catch (IOException | InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();				
		}
		
	}
	

	// Overrides from VendaFactory
	// -------------------------------
	@Override
	public Nfe criarNfe() {
		return this.nfe;	
	}
	
	@Override
	public Boleta criarBoleta() {		
		return this.boleta;		
	}
	
}
