package br.com.baraldi.agendadecorator.service;

import br.com.baraldi.agendadecorator.model.Contato;

public interface DAO {

	public void inserir(Contato contato);
	public Contato buscar(int codigo);
	public void setFileName(String fileName);
}
