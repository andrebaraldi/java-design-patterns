package br.com.baraldi.agendadecorator.main;

import br.com.baraldi.agendadecorator.model.Contato;
import br.com.baraldi.agendadecorator.service.AgendaDAO;
import br.com.baraldi.agendadecorator.service.CacheAgendaDAO;
import br.com.baraldi.agendadecorator.service.DAO;

public class Principal {
	
	private final static String CONTACT_LIST_FILE_XML = "agenda.xml";
	
	public static void main(String[] args) {
		
		
		// Load Data
		DAO agendaDAO = new CacheAgendaDAO( new AgendaDAO());
		agendaDAO.setFileName(CONTACT_LIST_FILE_XML);
		
		// Inserts...
		Contato contato = new Contato(671, "Antonio", "71717171" );		
		agendaDAO.inserir( contato  );

		// Get...
		Contato contatoAgain = agendaDAO.buscar(671);		
		System.out.printf("Contato capturado: %s", contatoAgain.getNome());
		
	}

}
