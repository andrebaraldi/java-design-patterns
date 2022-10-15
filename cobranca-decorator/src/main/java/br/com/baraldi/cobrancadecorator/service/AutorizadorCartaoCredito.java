package br.com.baraldi.cobrancadecorator.service;

import br.com.baraldi.cobrancadecorator.exception.RiscoCreditoException;
import br.com.baraldi.cobrancadecorator.model.CartaoCredito;
import br.com.baraldi.cobrancadecorator.model.Cliente;

public interface AutorizadorCartaoCredito {

	public void autorizar(Cliente cliente, CartaoCredito cartaoCredito, double valor) throws RiscoCreditoException;

}
