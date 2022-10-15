package br.com.baraldi.pedidovendas.bean.impl;

import java.math.BigDecimal;
import java.util.Date;

import javax.inject.Inject;

import br.com.baraldi.pedidovendas.bean.CalculadoraImposto;
import br.com.baraldi.pedidovendas.bean.PedidoVendaService;
import br.com.baraldi.pedidovendas.model.PedidoVenda;
import br.com.baraldi.pedidovendas.repository.PedidoVendas;


public class PedidoVendaServiceImpl implements PedidoVendaService {

    @Inject
    private PedidoVendas pedidoVendas;
    
    @Inject
    private CalculadoraImposto calculadoraImposto;
     
    
    public PedidoVendaServiceImpl(PedidoVendas pedidoVenda, CalculadoraImposto calculadoraImposto) {
        this.pedidoVendas = pedidoVenda;
     	this.calculadoraImposto = calculadoraImposto;
    }
	
	
	@Override
	public void salvar(PedidoVenda pedidoVenda) {
	
      pedidoVenda.setData(new Date());
      
      BigDecimal imposto = calculadoraImposto.calcular(pedidoVenda.getValor());
      
      pedidoVenda.setImposto(imposto);
      
      pedidoVendas.salvar(pedidoVenda);
		
	}
	

}
