package br.com.baraldi.pedidosobserver.sources;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import br.com.baraldi.pedidosobserver.model.Pedido;


public class PedidosXML {
	
	private List<Pedido> pedidos;
	
	public List<Pedido> getFromXML(String fileName){

		// XStream
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		
		// XML File Structure
	    xstream.alias("pedidos", List.class);
	    xstream.alias("pedido", Pedido.class);
	    	  
    	// Load the file content on List (this files have the same Pedido class attributes) 
    	this.pedidos = (List<Pedido>) xstream.fromXML(this.getClass().getResource("/" + fileName));
    	
    	return this.pedidos;
   }

}
