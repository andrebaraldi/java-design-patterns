package br.baraldi.sendmailproxy.sender;

import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import br.baraldi.sendmailproxy.model.Contato;


//----------------------------------------------
// Classe ContatoBlackList
// Provém lista de Contatos da Black List
//----------------------------------------------
public class ContatoBlackList {

	private List<Contato> mailsBlackList;
	
	private final String BLACK_LIST_FILE_XML = "blacklist.xml";
	
	
	// Constructor
	// ------------------------------------------------
	public ContatoBlackList() {	
		
		getBlackListFromXML(); // Loads the black list
	}
	
	
	// Get
	// ------------------------------------------------
	public List<Contato> getMailsBlackList(){
		return this.mailsBlackList;
	}
		
	// Read a XML file to load the black list
	// ------------------------------------------------
	@SuppressWarnings("unchecked")
	private void getBlackListFromXML(){
		
		// XStream and XMl file structure
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);

		xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
    	// Load the file content on List (this files have the same Contato Class attributes) 
	    this.mailsBlackList = (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + BLACK_LIST_FILE_XML));
	    
	}
	
	
	// Inform if the mail is a mail black list
	// ------------------------------------------------
	public boolean getMailBlackList(String mail) {
		
		for (Contato contato : this.mailsBlackList) {
			if (mail.equals(contato.getMail())) return true;
		}		
		return false;
	}
	
	
}
