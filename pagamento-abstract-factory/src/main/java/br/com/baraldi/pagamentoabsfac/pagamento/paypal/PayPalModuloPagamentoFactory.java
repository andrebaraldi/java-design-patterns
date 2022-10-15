package br.com.baraldi.pagamentoabsfac.pagamento.paypal;

import br.com.baraldi.pagamentoabsfac.gestorderisco.GestorDeRisco;
import br.com.baraldi.pagamentoabsfac.gestorderisco.clearsale.ClearSale;
import br.com.baraldi.pagamentoabsfac.operadora.Operadora;
import br.com.baraldi.pagamentoabsfac.operadora.redecard.RedeCard;
import br.com.baraldi.pagamentoabsfac.pagamento.ModuloPagamentoFactory;

public class PayPalModuloPagamentoFactory implements ModuloPagamentoFactory{

	@Override
	public Operadora criaOperadora() {
		return new RedeCard();
	}

	@Override
	public GestorDeRisco criarGestorDeRisco() {
		return new ClearSale();
	}
	
}
