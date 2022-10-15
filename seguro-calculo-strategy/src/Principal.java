import java.util.Scanner;

import br.com.baraldi.segurostrategy.model.Cliente;
import br.com.baraldi.segurostrategy.model.Sexo;
import br.com.baraldi.segurostrategy.model.TipoVeiculo;
import br.com.baraldi.segurostrategy.util.PropostaSeguro;

public class Principal {

	public static void main(String[] args) {
		
		Scanner scanner =  new Scanner(System.in);
		Cliente cliente =  new Cliente();		
		PropostaSeguro proposta;
		TipoVeiculo tipoVeiculo;
		Double valorVeiculo;		
		
		System.out.println("Nome do Cliente: ");
		cliente.setNome( scanner.nextLine() );
		
		System.out.println("Idade:");
		cliente.setIdade( scanner.nextInt());
		
		System.out.println("Sexo [1 - Masculino] [2 - Feminino]:");
		cliente.setSexo( Sexo.values()[scanner.nextInt() - 1] ); 
		
		System.out.println("Tipo [1 - Carro] [2 - Moto]:");
		tipoVeiculo = TipoVeiculo.values()[scanner.nextInt()-1]; 
		
		System.out.print("Valor: ");
		valorVeiculo = scanner.nextDouble();
		
		proposta = new PropostaSeguro(cliente);
		proposta.setCalculadora(tipoVeiculo.getCalculadoraPremioSeguro());
		
		System.out.println(proposta.gerar(valorVeiculo));

	}

}
