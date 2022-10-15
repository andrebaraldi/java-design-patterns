package br.com.baraldi.agendadecorator.service;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import br.com.baraldi.agendadecorator.model.Contato;


public class CacheAgendaDAO implements DAO {

	private AgendaDAO agendaDAO;
	private Map<Integer, Contato> contatos;
	
	// Construtor
	// ------------------
	public CacheAgendaDAO( AgendaDAO agendaDAO ) {
		this.agendaDAO = agendaDAO;
	}
	
	
	// Set Filename e load the cache
	// ---------------------------------------
	public void setFileName(String fileName) {
		
		this.agendaDAO.setFileName(fileName);
		
		this.contatos = this.agendaDAO.getContatos()
				            .stream()
				            .collect( Collectors.toMap(c -> c.getCodigo(), Function.identity() )  ) ;		
	}

	
	// ----------------------
	// From DAO interface
	// ----------------------	
	@Override
	public void inserir(Contato contato) {
		// inserts on file and cache
		this.agendaDAO.inserir(contato);		
		this.contatos.put(contato.getCodigo(), contato);
	}

	@Override
	public Contato buscar(int codigo) {
		// get from cache...
		return ( this.contatos.get(codigo) == null ? null : this.contatos.get(codigo)) ;
	}

}
