package br.com.baraldi.venda_absfactory.model.nfe;

import java.math.BigDecimal;
import br.com.baraldi.venda_absfactory.lib.model.Nfe;
import br.com.baraldi.venda_absfactory.model.Estados;


public class NfeRJ implements Nfe {

	private Estados estado = Estados.RJ;
	
	@Override
	public void gerar() {
		System.out.println("----------------------------------");
		System.out.println("Gerando NFE para " + estado.getNome());	
		System.out.println("----------------------------------");
	}

	@Override
	public void calcularImposto(BigDecimal valorNota) {
		System.out.println("--------------------------------------------");
		System.out.println("Calculando imposto para " + estado.getNome() + ":");	
		System.out.println("--------------------------------------------");
		
		System.out.println("Valor da Nota: " + valorNota);
		System.out.println("Percentual do Imposto: " + estado.getImposto());
		System.out.println("Valor do Imposto: " + valorNota.multiply(estado.getImposto()) );
	
		System.out.println("--------------------------------------------");
		System.out.println("Total: " + valorNota.add( valorNota.multiply(estado.getImposto()) ));
		System.out.println("--------------------------------------------");		
		
		System.out.println("Obs.: Impostos recolhidos no estado " + estado.getNome() + 
				           "\ndevem ser repassados à União em sua totalidade");
	}
	
}
