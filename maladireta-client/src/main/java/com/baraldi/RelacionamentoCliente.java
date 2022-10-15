package com.baraldi;

import javax.swing.JOptionPane;

import com.baraldi.maladireta.MalaDireta;         // From maladireta-factory
import com.baraldi.maladireta.csv.MalaDiretaCSV;  // Implementação de maladireta-factory.MalaDireta

public class RelacionamentoCliente {

	public static void main(String[] args) {
		
		// Instancia uma malaDireta do tipo que desejamos (no caso, CSV)
		MalaDireta malaDireta = new MalaDiretaCSV("contatos.csv");
		
		String mensagem = JOptionPane.showInputDialog(null, "Digite a mensagem do e-mail");
		
		// Envia a malaDireta (de 
		boolean status = malaDireta.enviarEmail(mensagem);
		
		JOptionPane.showConfirmDialog(null, "Emails enviados:"+ status);
	}
	
}
