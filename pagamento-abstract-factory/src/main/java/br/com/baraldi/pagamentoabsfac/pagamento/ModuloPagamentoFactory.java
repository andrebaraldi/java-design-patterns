package br.com.baraldi.pagamentoabsfac.pagamento;

import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;

public interface ModuloPagamentoFactory {
	
	public Operadora criaOperadora();
	public GestorDeRisco criarGestorDeRisco();
	 
}
