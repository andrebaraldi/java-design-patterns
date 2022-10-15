package br.com.baraldi.segurostrategy.model;

import java.util.Objects;

public class Cliente {

	private String nome;
	private int idade;
	private Sexo sexo;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getIdade() {
		return idade;
	}
	public void setIdade(int idade) {
		this.idade = idade;
	}
	public Sexo getSexo() {
		return sexo;
	}

	public void setSexo(Sexo sexo) {
		this.sexo = sexo;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idade, nome, sexo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		
		if (obj == null)
			return false;
		
		if (getClass() != obj.getClass())
			return false;
		
		Cliente other = (Cliente) obj;
		
		return (this.idade == other.idade) && 
			   (Objects.equals(this.nome, other.nome)) && 
			   (this.sexo == other.sexo);
	}
	
	
}
