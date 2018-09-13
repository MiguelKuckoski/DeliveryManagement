package apresentacao;

import controle.ControleVeiculo;
import entidade.Motorista;
import entidade.Pacote;

public class Main {

	public static void main(String[] args) {

		// ControladorPrincipal controlado = new ControladorPrincipal();

		String marca = "marca teste";
		String modelo = "modelo teste";
		int ano = 22;
		String placa = "placa teste";
		Motorista motoristaTeste = new Motorista();

		ControleVeiculo controleVeiculo = new ControleVeiculo();
		Pacote listaDePacote[] = null;
		controleVeiculo.cadastrarVeiculo(motoristaTeste, marca, modelo, ano, placa, listaDePacote);

	}

	private static void menu() {

		int principal = 0;
		do {
			System.out.println("Menu Entrega Rapida\n" + "1 - Veiculo \n" + "2 - Pacote \n" + "3 - Motorista \n"
					+ "4 - Rota \n" + "0 - Sair \n");

			switch (principal) {
			case 1:
				break;
			case 2:
				break;
			case 3:
				break;
			case 4:
				break;
			default:
				System.out.println("Op��o Invalida");
			}

		} while (principal != 0);

	}

}
