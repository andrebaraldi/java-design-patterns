import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import br.com.baraldi.pedidobuilder.model.Cliente;
import br.com.baraldi.pedidobuilder.model.ItemPedido;
import br.com.baraldi.pedidobuilder.model.PedidoVenda;
import br.com.baraldi.pedidobuilder.model.builder.PedidoVendaBuilder;


public class PedidoVendaTest {

    @Test
	public void deveCalcularValorTotalPedidoParaClienteVip() {
            
        // Preparação
		PedidoVenda pedidoVenda = new PedidoVenda();
		
		Cliente cliente = new Cliente();
		cliente.setNome("João");
		cliente.setVip(true);
		pedidoVenda.setCliente(cliente);
		
		ItemPedido item1 = new ItemPedido();
		item1.setNome("Calculadora");
		item1.setValorUnitario(new BigDecimal("200"));
		item1.setQuantidade(2);
		
		ItemPedido item2 = new ItemPedido();
		item2.setNome("Mochila");
		item2.setValorUnitario(new BigDecimal("200"));
		item2.setQuantidade(1);
		
		List<ItemPedido> itensPedido = Arrays.asList(item1, item2);
		pedidoVenda.setItensPedido(itensPedido);
		
		// Execução
		BigDecimal valorTotal = pedidoVenda.getValorTotal();
		
		// Validação
		// Obs.: asserEquals não aceita BigDecimal, então usamos o método doubleValue
		assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	}
    
        
	@Test
	public void deveCalcularValorTotalPedidoParaClienteVipComBuilder() {
	    
	    // Criação do Cliente, usando Builder
	    PedidoVenda pedidoVenda = new PedidoVendaBuilder()
		    			.setClienteVip("João")
		    			.setItem("Calculadora", 2, "200.00")
		    			.setItem("Mochila", 1, "200.00")
		    			.construir();
	    
	    
	    BigDecimal valorTotal = pedidoVenda.getValorTotal();
	    
	    assertEquals(new BigDecimal("576").doubleValue(), valorTotal.doubleValue(), 0.0001);
	    
	}
        
}
