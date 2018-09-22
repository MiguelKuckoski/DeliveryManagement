package apresentacao;

import java.util.Random;
import java.util.Set;

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
				
				if(controlador.getControleMotorista().getMotoristaDAO().getListaMotorista().containsKey(cnhNum)) {
					JOptionPane.showMessageDialog(null, "Motorista com CNH ja cadastrada no sistema, cadastre outro motorista ou cnh diferente");
				}else {
					controlador.getControleMotorista().cadastrarMotorista(nome, nascimento, endereco, cnhNum, cnhTipo);
				}
				
				break;
			case 2:
				Set<String> chaves = controlador.getControleMotorista().getMotoristaDAO().getListaMotorista().keySet();
				
				for(String chave : chaves) {
					Motorista motorista = controlador.getControleMotorista().getMotoristaDAO().getListaMotorista().get(chave);
					
					System.out.println("CNH: "+chave+" - "+motorista.toString());
				}
				break;
			case 3:
				cnhNum = JOptionPane.showInputDialog("Digite o numero da CNH ");
				int confirma;
				if(controlador.getControleMotorista().getMotoristaDAO().getListaMotorista().containsKey(cnhNum)) {
					confirma = JOptionPane.showConfirmDialog(null, "Realmente deseja excluir o cliente", "Atenção",JOptionPane.YES_NO_OPTION);
					if(confirma == JOptionPane.YES_OPTION) {					
						JOptionPane.showMessageDialog(null,controlador.getControleMotorista().removerMotorista(cnhNum));						
					}					
				}else {
					JOptionPane.showMessageDialog(null,"Motorista não encontrado");
				}
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
			opcao = Integer.parseInt(JOptionPane.showInputDialog("--- Veiculo ---\n " + "1 - Inserir veiculo \n "
					+ "2 - Mostrar veiculos \n " + "3 - Vincular Motorista \n" + "4 - Listar Pacotes de um Veiculo \n"
					+ "5 - Remover motorista de um veiculo \n" + "0 - Voltar \n "));
			switch (opcao) {
			case 1:
				String marca = JOptionPane.showInputDialog("Insira a marca do veiculo:");
				String modelo = JOptionPane.showInputDialog("Insira o modelo do veiculo:");
				String placa = JOptionPane.showInputDialog("Insira a placa do veiculo:");
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veiculo:"));
				String tipo = JOptionPane
						.showInputDialog("---Tipo do veiculo--- \n" + "Van\n" + "Caminhao bau\n" + "Carreta.");
				if(controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo().containsKey(placa)) {
					JOptionPane.showMessageDialog(null,"Veiculo com placa ja cadastrado, altere a placa ou insira um veiculo diferente");
				}else {
					controlador.getControleVeiculo().cadastrarVeiculo(marca, modelo, placa, ano, tipo);
					JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
				}				
				break;
			case 2:				
				Set<String> chaves = controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo().keySet();
				
				for(String chave : chaves) {
					Veiculo veiculo = controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo().get(chave);					
					System.out.println("PLACA: "+chave+" - "+veiculo.toString());
				}
				break;
			case 3:
		
				String placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo");
				String cnhMotorista = JOptionPane.showInputDialog("Digite a CNH do motorista");
				JOptionPane.showMessageDialog(null, controlador.getControleVeiculo().vincularMotorista(placaVeiculo, cnhMotorista));
				
				break;
			case 4:

//				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
//					System.out.println(veiculos.toString());
//				}
//
//				placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo para ver seus pacotes");
//
//				for (Veiculo veiculos : controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo()) {
//					if (veiculos.equals(placaVeiculo) && veiculos.getListaDePacote() != null) {
//
//						for (Pacote pacotes : veiculos.getListaDePacote()) {
//							pacotes.toString();
//						}
//					}
//
//				}
				break;
			case 5:
				placaVeiculo = JOptionPane.showInputDialog("Digite a placa do veiculo para remover seu Motorista");
				if(controlador.getControleVeiculo().getVeiculoDAO().getListaVeiculo().containsKey(placaVeiculo)) {
					controlador.getControleVeiculo().desvincularMotorista(placaVeiculo);
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
