package br.com.baraldi.pedidovendas.bean;

import java.math.BigDecimal;

public interface CalculadoraImposto {

	public BigDecimal calcular(BigDecimal valor);
}
