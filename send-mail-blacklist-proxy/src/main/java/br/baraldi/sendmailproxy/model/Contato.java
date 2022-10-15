package br.baraldi.sendmailproxy.model;

import java.io.Serializable;
import java.util.Objects;

public class Contato implements Serializable {
	
	private String nome;
	private String mail;
	
	
	public Contato(String nome, String mail) {
		this.nome = nome;
		this.mail = mail;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	// ------------------------
	// From Mother Class
	// ------------------------
	@Override
	public int hashCode() {
		return Objects.hash(mail, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) return true;
		
		if (obj == null) return false;
		
		if (getClass() != obj.getClass()) return false;
		
		Contato other = (Contato) obj;
		
		return Objects.equals(mail, other.mail) && 
			   Objects.equals(nome, other.nome);
	}
	
}
