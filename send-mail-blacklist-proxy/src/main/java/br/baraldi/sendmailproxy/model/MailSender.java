package br.baraldi.sendmailproxy.model;

public interface MailSender {

	public void send();
	
	public boolean getSendStatus();
	
	public int getSendCount();
	 
}
