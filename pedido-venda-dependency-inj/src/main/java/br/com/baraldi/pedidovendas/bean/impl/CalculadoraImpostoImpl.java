package br.com.baraldi.pedidovendas.bean.impl;

import java.math.BigDecimal;

import br.com.baraldi.pedidovendas.bean.CalculadoraImposto;

public class CalculadoraImpostoImpl implements CalculadoraImposto {

	@Override
	public BigDecimal calcular(BigDecimal valor) {
		return valor.multiply(new BigDecimal("0.15"));
	}

}
