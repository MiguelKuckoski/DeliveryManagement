package apresentacao;

import java.util.Collection;

import javax.swing.JOptionPane;

import controle.ControladorPrincipal;
import entidade.Endereco;
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
		Motorista motorista = new Motorista();

		Pacote listaDePacote[] = null;
		controlador.getControleviculo().cadastrarVeiculo(motorista, marca, modelo, ano, placa, listaDePacote);
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

	private static void cadastroMotorista() {

		String nome = JOptionPane.showInputDialog("Digite o nome do motorista");
		String nascimento = JOptionPane.showInputDialog("Digite a data de nascimento do motorista");
		String cnhNum = JOptionPane.showInputDialog("Digite o número da CNH");
		String cnhTipo = JOptionPane.showInputDialog("Digite o tipo da CNH");
		Endereco endereco = cadastroEndereco();

		// cadastrando motorista e salvando em arquivo motorista.dat
		controlador.getControleMotorista().cadastrarMotorista(nome, nascimento, endereco, cnhNum, cnhTipo);

	}

	private static Endereco cadastroEndereco() {

		String rua = JOptionPane.showInputDialog("Digite o nome da rua");
		int cep = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero de CEP"));
		String bairro = JOptionPane.showInputDialog("Digite o nome do bairro");
		String cidade = JOptionPane.showInputDialog("Digite o nome da cidade");
		String estado = JOptionPane.showInputDialog("Digite o nome da Estado");
		String complemento = JOptionPane.showInputDialog("Digite o complemento");

		Endereco endereco = new Endereco(rua, bairro, cidade, estado, complemento, cep);

		return endereco;
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
