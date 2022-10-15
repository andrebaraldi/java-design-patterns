package br.com.baraldi.pedidobuilder.model;

public class Cliente {
    
        // Atributos 
        private String nome;	
        private boolean vip;

        // Get/Set
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public boolean isVip() {
		return vip;
	}

	public void setVip(boolean vip) {
		this.vip = vip;
	}
}
