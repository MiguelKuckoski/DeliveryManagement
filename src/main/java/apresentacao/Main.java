package apresentacao;

import java.util.Collection;

import javax.swing.JOptionPane;

import controle.ControladorPrincipal;
import entidade.Motorista;
import entidade.Pacote;
import entidade.Veiculo;
import persistencia.MotoristaDAO;
import persistencia.VeiculoDAO;

public class Main {

	private static ControladorPrincipal controlador = new ControladorPrincipal();

	public static void main(String[] args) {

		String marca = "marca teste3";
		String modelo = "modelo teste3";
		int ano = 22;
		String placa = "placa teste3";

		Pacote listaDePacote[] = null;
		
		controlador.getControleviculo().cadastrarVeiculo(marca, modelo, placa, ano, "van");
		Collection<Veiculo> veiculos = new VeiculoDAO().getListaVeiculo();
		Collection<Motorista> motoristas = new MotoristaDAO().getListaMotorista();

		for (Motorista motorista2 : motoristas) {
			System.out.println(motorista2.toString());
		}

		for (Veiculo veiculo : veiculos) {
			System.out.println(veiculo.getMarca());
		}

		cadastroMotorista();

	}

	private static void cadastroVeiculo() {

		String marca = JOptionPane.showInputDialog("");
		String modelo = JOptionPane.showInputDialog("");
		String placa = JOptionPane.showInputDialog("");
		int ano = Integer.parseInt(JOptionPane.showInputDialog(""));

		int tipoVeiculo = 0;
		do {

			tipoVeiculo = Integer.parseInt(JOptionPane.showInputDialog("1 - Carreta 2 - Caminhao 3 - Van"));

			switch (tipoVeiculo) {
			case 1:

				break;
			case 2:
				break;
			case 3:
				break;
			default:
				System.out.println("Caminhão inválido");
				break;
			}
		} while (tipoVeiculo != 0);

	}

	private static void cadastroMotorista() {

		String nome = JOptionPane.showInputDialog("Digite o nome do motorista");
		String nascimento = JOptionPane.showInputDialog("Digite a data de nascimento do motorista");
		String cnhNum = JOptionPane.showInputDialog("Digite o número da CNH");
		String cnhTipo = JOptionPane.showInputDialog("Digite o tipo da CNH");
		String endereco = JOptionPane.showInputDialog("Digite o endereco");

		// cadastrando motorista e salvando em arquivo motorista.dat
		controlador.getControleMotorista().cadastrarMotorista(nome, nascimento, endereco, cnhNum, cnhTipo);

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
