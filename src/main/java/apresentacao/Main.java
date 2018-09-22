package apresentacao;

import java.util.Random;

import javax.swing.JOptionPane;

import controle.ControladorPrincipal;
import entidade.Motorista;
import entidade.Pacote;
import entidade.Veiculo;

public class Main {

	private static ControladorPrincipal controlador = new ControladorPrincipal();

	public static void main(String[] args) {

		int principal = 0;
		do {
			principal = Integer.parseInt(JOptionPane.showInputDialog("Menu Entrega Rapida\n" + " 1 - Veiculo \n"
					+ " 2 - Pacote \n" + " 3 - Motorista \n" + " 4 - Rota \n" + " 0 - Sair \n"));

			switch (principal) {
			case 1:
				veiculo();
				break;
			case 2:
				pacote();
				break;
			case 3:
				motorista();
				break;
			case 4:
				rota();
				break;
			case 0:
				System.out.println(" Sair ");
				break;
			default:
				System.out.println("Opção Invalida");
			}

		} while (principal != 0);

	}

	private static void motorista() {
		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("--- Motorista ---\n " + " 1 - Inserir Motorista \n "
					+ " 2 - Listar motoristas \n " + "3 - Apagar Motorista \n" + " 0 - Voltar \n "));
			switch (opcao) {
			case 1:
				String nome = JOptionPane.showInputDialog("Digite o nome");
				String nascimento = JOptionPane.showInputDialog("Digite a data de nascimento");
				String cnhNum = JOptionPane.showInputDialog("Digite o numero da CNH ");
				String cnhTipo = JOptionPane.showInputDialog("Digite o tipo da cnh B ou C");
				String endereco = JOptionPane.showInputDialog("Digite o endereço");

				controlador.getControleMotorista().cadastrarMotorista(nome, nascimento, endereco, cnhNum, cnhTipo);

				break;
			case 2:
				for (Motorista motoristas : controlador.getControleMotorista().getMotoristaDAO().getListaMotorista()) {
					System.out.println(motoristas.toString());
				}
				break;
			case 3:

				break;
			case 0:
				System.out.println("Saindo do menu Motorista");
				break;
			default:
				break;
			}
		} while (opcao != 0);
	}

	public static void veiculo() {
		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("--- Veiculo ---\n " + " 1 - Inserir veiculo \n "
					+ " 2 - Mostrar veiculos \n " + "3 - Vincular Motorista \n" + " 4 - Listar Pacotes de um Veiculo \n"
					+ "5 - Remover motorista de um veiculo" + " 0 - Voltar \n "));
			switch (opcao) {
			case 1:
				String marca = JOptionPane.showInputDialog("Insira a marca do veiculo:");
				String modelo = JOptionPane.showInputDialog("Insira o modelo do veiculo:");
				String placa = JOptionPane.showInputDialog("Insira a placa do veiculo:");
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veiculo:"));
				String tipo = JOptionPane
						.showInputDialog("---Tipo do veiculo--- \n" + "Van\n" + "Caminhao bau\n" + "Carreta.");
				controlador.getControleVeiculo().cadastrarVeiculo(marca, modelo, placa, ano, tipo);
				break;
			case 2:
				controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo().forEach(veiculo -> {
					System.out.println(veiculo.toString());
				});
				break;
			case 3:

				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
					System.out.println(veiculos.toString());
				}
				String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo");

				for (Motorista motoristas : controlador.getControleMotorista().getMotoristaDAO().getListaMotorista()) {
					System.out.println(motoristas.toString());
				}
				String cnhMotorista = JOptionPane.showInputDialog("Digite a CNH do motorista");

				controlador.getControleVeiculo().vincularMotorista(placaVeiculo, cnhMotorista);
				break;
			case 4:

				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
					System.out.println(veiculos.toString());
				}

				placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo para ver seus pacotes");

				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
					if (veiculos.equals(placaVeiculo) && veiculos.getListaDePacote() != null) {

						for (Pacote pacotes : veiculos.getListaDePacote()) {
							pacotes.toString();
						}
					}

				}

				break;

			case 5:
				placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo para remover seu Motorista");
				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
					if (veiculos.equals(placaVeiculo)) {
						veiculos.setMotorista(null);
						JOptionPane.showMessageDialog(null, "Removido motorista com sucesso");
					}
				}

				break;

			case 0:
				break;

			default:
				System.out.println("Opção invalida.");
				break;
			}
		} while (opcao != 0);
	}

	public static void pacote() {

		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog(
					" Pacote \n " + " 1 - Criar pacote \n " + " 2 - Localizar pacotes não entregues \n "
							+ " 3 - Localizar pacotes entregues \n " + " 0 - sair"));

			switch (opcao) {
			case 1:
				String nomeRemetente = JOptionPane.showInputDialog("Informe o nome do remetente:");
				String nomeDestino = JOptionPane.showInputDialog("Informe o nome do destinatário:");
				String codLocalizador = JOptionPane.showInputDialog(
						"Informe o código localizador(ou deixe em branco para gerar automaticamente: ");
				if (codLocalizador.isEmpty()) {
					codLocalizador = String.valueOf(new Random().nextInt(100) + 1);
				}
				String endRemetente = JOptionPane.showInputDialog("Informe o endereço do remetente:");
				String endDestino = JOptionPane.showInputDialog("Informe o endereço do destinat�rio:");
				double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do pacote:"));
				controlador.getControlePacote().cadastrarPacote(nomeRemetente, nomeDestino, codLocalizador,
						endRemetente, endDestino, peso);
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				break;
			default:
				System.out.println("Opção inválida.");
			}
		} while (opcao != 0);
	}

	private static void rota() {
		int rota = 0;
		do {
			rota = Integer.parseInt(JOptionPane.showInputDialog("Menu Entrega Rapida\n" + " 1 - Gerar rota \n"
					+ " 2 - Ler baixas \n" + " 3 - Mostrar pacotes n�o roteirizados \n" + " 0 - Sair"));
			switch (rota) {
			case 1:
				controlador.getControleRota().criarRota(
						controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo(),
						controlador.getControlePacote().getPacoteDAO().getListaPacote());
				break;
			case 2:
				String dataBusca = JOptionPane.showInputDialog("Digite uma data no seguinte formato dd-mm-aaaa");
				dataBusca = dataBusca + "-rota.xls";
				controlador.getControleRota().LerRota(dataBusca);
				break;
			case 3:
				break;
			case 4:

				break;
			case 0:
				System.out.println(" Sair ");
				break;
			default:
				System.out.println("Opção Invalida");
			}
		} while (rota != 0);
	}
}
