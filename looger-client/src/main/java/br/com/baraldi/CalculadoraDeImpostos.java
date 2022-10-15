package br.com.baraldi;

// Classe para logar em Tela
import br.com.baraldi.logger.screen.LoggerWriterScreen;
import br.com.baraldi.logger.text.LoggerWriterText;

public class CalculadoraDeImpostos {

	public static void main(String[] args) {
		
	    // Usando a lib de Logger
	    LoggerWriterScreen logger = new LoggerWriterScreen();
		
	    // Cálculos
	    float valorCompra = 100.00f;
	    float imposto = 0.1f;
	    double valorTotal = valorCompra + (valorCompra * imposto);
			
	    // Efetua o Log do Calculo
	    logger.geraLog( "Valor da Compra: " + Float.toString(valorCompra) );
	    logger.geraLog( "Imposto: " + Float.toString(imposto) + "%");
	    logger.geraLog( "---------------------------------------");
	    logger.geraLog( "Valor total da compra é: " + Double.toString(valorTotal) );
		
		
	    // No arquivo texto, grava somente o total
	    // ----------------------------------------
	    LoggerWriterText loggerTxt = new LoggerWriterText("logs.txt");
		
	    loggerTxt.geraLog("Valor total da compra é: " + Double.toString(valorTotal) );
		
	}
	
}


