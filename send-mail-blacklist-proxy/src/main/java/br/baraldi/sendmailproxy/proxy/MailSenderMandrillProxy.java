package br.baraldi.sendmailproxy.proxy;

import java.util.ArrayList;
import java.util.List;

import br.baraldi.sendmailproxy.model.Contato;
import br.baraldi.sendmailproxy.model.MailSender;
import br.baraldi.sendmailproxy.sender.ContatoBlackList;
import br.baraldi.sendmailproxy.sender.MailSenderMandrill;

//--------------------------------------------------------
//Classe MailSenderMandrillProxy
//Recebe uma Lista de Contatos e envia emails, exceto os da
//Black List
//--------------------------------------------------------
public class MailSenderMandrillProxy implements MailSender {
	
	private MailSenderMandrill mailSenderMandrill;
	
	private ContatoBlackList contatosBlackList = new ContatoBlackList();
		
	
	// ---------------------
	// Constructor
	// ---------------------
	public MailSenderMandrillProxy (List<Contato> mails) {
		this.mailSenderMandrill = new MailSenderMandrill(mails);
	}
	
	
	// ---------------------
	// Get
	// ---------------------
	public List<Contato> getBlackList (){
		return this.contatosBlackList.getMailsBlackList();
	}
	
	public boolean getMailBlackList(String mail) {
		return this.contatosBlackList.getMailBlackList(mail);
	}
	
	// ---------------------------
	// From MailSender Interface
	// --------------------------	
	@Override
	public void send() {
		
		List<Contato> differences = new ArrayList<>(this.mailSenderMandrill.getMails());
		
		differences.removeAll(this.contatosBlackList.getMailsBlackList());
		
		this.mailSenderMandrill.getMails().clear();
		this.mailSenderMandrill.getMails().addAll(differences);
		
		// First, remove black list
	
		
		// Send...
		this.mailSenderMandrill.send();
	}

	@Override
	public boolean getSendStatus() {
		return this.mailSenderMandrill.getSendStatus();
	}

	@Override
	public int getSendCount() {
		return this.mailSenderMandrill.getSendCount();
	}

}
