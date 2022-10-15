package br.com.baraldi.pagamentoabsfac.pagamento.pagseguro;

//Interface 
import br.com.baraldi.pagamentoabsfac.pagamento.ModuloPagamentoFactory;

// Operadora Cielo
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;
import br.com.baraldi.pagamentoabsfac.operadora.cielo.Cielo;

//Gestor de Risco FControl
import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.gestorderisco.fcontrol.FControl;


//------------------------------------------------------------------
// Fabrica os objetos referente ao pagamento de PagSeguro
// ------------------------------------------------------------------
public class PagSeguroModuloPagamentoFactory implements ModuloPagamentoFactory{

	@Override
	public Operadora criaOperadora() {
		return new Cielo();
	}

	@Override
	public GestorDeRisco criarGestorDeRisco() {
		return new FControl();
	}

}
