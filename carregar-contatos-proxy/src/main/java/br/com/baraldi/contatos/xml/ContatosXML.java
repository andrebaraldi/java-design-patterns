package br.com.baraldi.contatos.xml;

//Java SE
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//XStream
import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

//Me...
import br.com.baraldi.contatos.repository.Contatos;
import br.com.baraldi.contatos.xml.model.Contato;


//----------------
// Class Proxy
// ----------------
public class ContatosXML implements Contatos {

	// Map to name/mail list
	private Map<String, String> contatosEmCache = new HashMap<>();

	// ---------------------------
	// Constructor
	// ---------------------------	
	@SuppressWarnings("unchecked")
    public ContatosXML(String... nomesArquivos) {
		
		// XStream
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		
		// XML File Structure
	    xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
	    // Sweep the file list received on the constructor
	    for (String nomeArquivo : nomesArquivos) {
	    	
	    	System.out.println("Carregando arquivo: " + nomeArquivo);
	    	
	    	// Load the file content on List (this files have the same Contato Class attributes) 
	    	List<Contato> contatosCarregados = (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + nomeArquivo));
	    	
	    	// Sweep de Contacts List
	    	for (Contato contato : contatosCarregados) {
	    		// Put on MAP
	    		contatosEmCache.put(contato.getEmail(), contato.getNome());
	    	}
	    }
	}
	
	@Override
    public String buscarPor(String email) {
	    return contatosEmCache.get(email);
    }

}
