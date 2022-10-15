package br.com.baraldi.pedidovendas.repository.xml;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import br.com.baraldi.pedidovendas.model.PedidoVenda;
import br.com.baraldi.pedidovendas.repository.PedidoVendas;


public class XMLPedidosVendasRepository implements PedidoVendas {

	@Override
    public void salvar(PedidoVenda pedidoVenda) {
		
		// XStream and XMl file structure
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		
	    xstream.alias("pedido-venda", PedidoVenda.class);
	    OutputStream out = null;
        
	    try {
	        out = new FileOutputStream(pedidoVenda.getDescricao() + ".xml");
	        xstream.toXML(pedidoVenda, out);
	        
        } catch (FileNotFoundException e) {
	        throw new RuntimeException("Erro salvando arquivo", e);
        }
	    
    }
	
}
