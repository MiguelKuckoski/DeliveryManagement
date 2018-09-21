import java.util.Collection;
import java.util.List;
import java.util.Random;

import javax.swing.JOptionPane;

import controle.ControladorPrincipal;
import entidade.Motorista;
import entidade.Pacote;
import entidade.Veiculo;
import persistencia.MotoristaDAO;
import persistencia.PacoteDAO;
import persistencia.VeiculoDAO;

public class Main {

	private static ControladorPrincipal controlador = new ControladorPrincipal();
	static Collection<Veiculo> veiculos = new VeiculoDAO().getListaVeiculo();
	Collection<Motorista> motoristas = new MotoristaDAO().getListaMotorista();
	static Collection<Pacote> pacotes = new PacoteDAO().getListaPacote();

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
				System.out.println("OpÃ§Ã£o Invalida");
			}

		} while (principal != 0);

	}

	private static void motorista() {
		// TODO Auto-generated method stub

	}

	public static void veiculo() {
		int opcao;
		do {
			opcao = Integer.parseInt(JOptionPane.showInputDialog("--- Veiculo ---\n " + " 1 - Inserir veiculo \n "
					+ " 2 - Mostrar veiculos \n " + " 0 - Voltar \n "));
			switch (opcao) {
			case 1:
				String marca = JOptionPane.showInputDialog("Insira a marca do veiculo:");
				String modelo = JOptionPane.showInputDialog("Insira o modelo do veiculo:");
				String placa = JOptionPane.showInputDialog("Insira a placa do veiculo:");
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Informe o ano do veiculo:"));
				String tipo = JOptionPane.showInputDialog("---Tipo do veiculo--- \n" +
				"1. Van\n"+ "2. Caminhao bau\n" +"3. Carreta.");
				controlador.getControleVeiculo().cadastrarVeiculo(marca, modelo, placa, ano, tipo);
				break;
			case 2:
				// TODO listarVeiculos();
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
			opcao = Integer.parseInt(JOptionPane.showInputDialog(" Pacote \n " + " 1 - Criar pacote \n "
					+ " 2 - Localizar pacotes não entregues \n " + " 3 - Localizar pacotes entregues \n " + " 0 - sair"));
			
			switch(opcao) {
			case 1:
				String nomeRemetente = JOptionPane.showInputDialog("Informe o nome do remetente:");
				String nomeDestino = JOptionPane.showInputDialog("Informe o nome do destinatário:");
				String codLocalizador = JOptionPane.showInputDialog("Informe o código localizador(ou deixe em branco para gerar automaticamente: ");
				if(codLocalizador.isEmpty()) {
					codLocalizador = String.valueOf(new Random().nextInt(100) +1 );
				}
				String endRemetente = JOptionPane.showInputDialog("Informe o endereço do remetente:");
				String endDestino = JOptionPane.showInputDialog("Informe o endereço do destinatário:");
				double peso = Double.parseDouble(JOptionPane.showInputDialog("Informe o peso do pacote:"));				
				controlador.getControlePacote().cadastrarPacote(nomeRemetente, nomeDestino, codLocalizador, endRemetente, endDestino, peso);
				break;
			case 2:
				break;
			case 3:
				break;
			case 0:
				break;
				default:
					System.out.println("Opção invalida.");
			}
		} while (opcao != 0);
	}

	private static void rota() {
		int rota = 0;
		do {
			rota = Integer.parseInt(JOptionPane.showInputDialog("Menu Entrega Rapida\n" + " 1 - Gerar rota \n"
					+ " 2 - Ler baixas \n" + " 3 - Mostrar pacotes não roteirizados \n" + " 0 - Sair"));
			switch (rota) {
			case 1:
				controlador.getControleRota().criarRota(((List<Veiculo>) veiculos), (List<Pacote>) pacotes);
				break;
			case 2:

				break;
			case 3:
				break;
			case 4:

				break;
			case 0:
				System.out.println(" Sair ");
				break;
			default:
				System.out.println("OpÃ§Ã£o Invalida");
			}
		} while (rota != 0);
	}
}
