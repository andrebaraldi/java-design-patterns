package br.baraldi.sendmailproxy.sender;

import java.util.ArrayList;
import java.util.List;

import br.baraldi.sendmailproxy.model.Contato;
import br.baraldi.sendmailproxy.model.MailSender;


//--------------------------------------------------------
//Classe MailSenderMandrill
//Recebe uma Lista de Contatos e envia emails
//--------------------------------------------------------
public class MailSenderMandrill implements MailSender {
	
	private List<Contato> mails = new ArrayList<>();
	
	private boolean status;
	private int count;
	
	
	// ---------------------
	// Constructor
	// ---------------------
	public MailSenderMandrill (List<Contato> mails) {
		this.mails = mails;
	}
	

	// ---------------------------
	// Get/Set
	// ---------------------------	
	private void setStatus(boolean status) { this.status = status; }
	
	public List<Contato> getMails() { return this.mails; }
	
	
	// ---------------------------
	// From MailSender Interface
	// ---------------------------
	@Override
	public void send() {
		
		setStatus(false);
		this.count = 0;
		
		try
		{						
			for (Contato contato : this.mails) {
				
				System.out.println("===================================");
				System.out.println("To: " + contato.getMail());
				System.out.println("Title: Proxy Design Pattern ");
				System.out.println("Subject: Dear " + contato.getNome() + "," +
				                            " Do you know Proxy Design Pattern ?");
				this.count++;
			}
			
			setStatus(true);
		}
		
		catch (Exception e ) {
		
			System.out.println("Erro ao enviar email: " + e.getMessage());
		}		
	}
	
	
	@Override
	public boolean getSendStatus() { return this.status; }

	@Override
	public int getSendCount() { return this.count; };
	
	
}
