package br.com.baraldi.agendadecorator.service;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Optional;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.security.AnyTypePermission;

import br.com.baraldi.agendadecorator.model.Contato;


public class AgendaDAO implements DAO {

	private String fileName;
	private List<Contato> contatos;
	
		
	// Get/Set
	// ---------
	public void setFileName(String fileName) { 
		
		this.fileName = fileName;
		loadFile();
	}
	
	public List<Contato> getContatos(){ 
		return this.contatos; 
	}
	
	
	// ------------------------------------	
	// Load file content to List contatos
	// ------------------------------------
	private void loadFile() {
		
		// XStream and XMl file structure
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);
		
		xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
		// Load the file content on List (this files have the same Contato Class attributes) 
	    this.contatos = (List<Contato>) xstream.fromXML(this.getClass().getResource("/" + this.fileName));	
	    
	}

	// ------------------------------------
	// Persists contatos List on file
	// ------------------------------------	
    private void saveFile() {		
    	
		// XStream and XMl file structure
		XStream xstream = new XStream();
		xstream.addPermission(AnyTypePermission.ANY);

		xstream.alias("contatos", List.class);
	    xstream.alias("contato", Contato.class);
	    
	    OutputStream out = null;
	    
		System.out.println("Atualizando arquivo XML...");
		
		try {
		    
			out = new FileOutputStream(this.fileName);
			xstream.toXML(this.contatos, out);
		
		} catch (FileNotFoundException e) {
		
			throw new RuntimeException("Erro a tentar salvar o contato no arquivo: " + e.getMessage());
		}
		
	}
	
    
    // ----------------------
	// From DAO interface
	// ----------------------
	@Override
	public void inserir(Contato contato) {
	    
		this.contatos.add(contato);		
		saveFile();		
	}
	
	@Override
	public Contato buscar(int codigo) {
		
		Optional<Contato> contato = this.contatos.stream().filter(c -> c.getCodigo().equals(codigo)).findFirst();
		
		return( contato.isPresent() ? contato.get() : null );		
	}

}
