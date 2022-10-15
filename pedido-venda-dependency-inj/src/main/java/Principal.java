import java.math.BigDecimal;

import br.com.baraldi.pedidovendas.bean.CalculadoraImposto;
import br.com.baraldi.pedidovendas.bean.PedidoVendaService;
import br.com.baraldi.pedidovendas.bean.impl.CalculadoraImpostoImpl;
import br.com.baraldi.pedidovendas.bean.impl.PedidoVendaServiceImpl;
import br.com.baraldi.pedidovendas.model.PedidoVenda;
import br.com.baraldi.pedidovendas.repository.PedidoVendas;
import br.com.baraldi.pedidovendas.repository.xml.XMLPedidosVendasRepository;
import br.com.baraldi.pedidovendas.util.cdi.WeldContext;

public class Principal {

	public static void main(String[] args) {
		
		// Veja que estamos enviando uma interface PedidoVendaService, mas o weld saberá,
		// dentro de nosso projeto, qual classe está implementando essa interface.
		// No caso, a classe PedidoVendaServiceImpl
		PedidoVendaService service = WeldContext.INSTANCE.getBean(PedidoVendaService.class);
	
		PedidoVenda pedidoVenda =  new PedidoVenda("sabonete", new BigDecimal("3.00"));
		
		service.salvar(pedidoVenda);

	}

}
