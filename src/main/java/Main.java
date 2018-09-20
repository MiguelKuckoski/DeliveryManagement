import javax.swing.JOptionPane;

public class Main {

	public static void case1() {
		int case1;

		do {
			case1 = Integer.parseInt(JOptionPane.showInputDialog(" Selecionar Veículo  \n " + " 1 - Carreta \n "
					+ " 2 - Caminhao \n " + " 3 - Van \n " + " 0 - Voltar \n "));

			if (case1 == 1) {

				String marca = JOptionPane.showInputDialog(" Insira a marca do veículo ");
				String modelo = JOptionPane.showInputDialog(" Insira o modelo do veículo ");
				String placa = JOptionPane.showInputDialog(" Insira a placa do veículo ");
				int ano = Integer.parseInt(JOptionPane.showInputDialog(" Informe o ano do veículo "));

			} else {
				if (case1 == 2) {

					String marca = JOptionPane.showInputDialog(" Insira a marca do veículo ");
					String modelo = JOptionPane.showInputDialog(" Insira o modelo do veículo ");
					String placa = JOptionPane.showInputDialog(" Insira a placa do veículo ");
					int ano = Integer.parseInt(JOptionPane.showInputDialog(" Informe o ano do veículo "));

				} else {
					if (case1 == 3) {

						String marca = JOptionPane.showInputDialog(" Insira a marca do veículo ");
						String modelo = JOptionPane.showInputDialog(" Insira o modelo do veículo ");
						String placa = JOptionPane.showInputDialog(" Insira a placa do veículo ");
						int ano = Integer.parseInt(JOptionPane.showInputDialog(" Informe o ano do veículo "));

					} else {
						if (case1 == 0) {

						}
					}
				}
			}

		} while (case1 != 0);

	}

	public static void case2() {

		int case2;
		do {
			case2 = Integer.parseInt(JOptionPane.showInputDialog(" Pacote \n " + " 1 - Criar pacote \n "
					+ " 2 - Localizar pacotes não entregues \n " + " 3 - Localizar pacotes entregues \n " + " 4 - "));
		} while (case2 != 0);
	}

	public static void main(String[] args) {

		int principal = 0;
		do {
			principal = Integer.parseInt(JOptionPane.showInputDialog("Menu Entrega Rapida\n" + " 1 - Veiculo \n"
					+ " 2 - Pacote \n" + " 3 - Motorista \n" + " 4 - Rota \n" + " 0 - Sair \n"));

			switch (principal) {
			case 1:
				case1();
				break;
			case 2:
				case2();
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

		} while (principal != 0);

	}

}
