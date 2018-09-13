package controle;

import entidade.Motorista;
import entidade.Pacote;
import entidade.Veiculo;
import persistencia.VeiculoDAO;

public class ControleVeiculo {

	private VeiculoDAO veiculoDAO;

	public ControleVeiculo() {
		this.veiculoDAO = new VeiculoDAO();
	}

	public void cadastrarVeiculo(Motorista motorista, String marca, String modelo, int ano, String placa,
			Pacote listaDePacote[]) {

		Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, listaDePacote, motorista);
		veiculoDAO.put(veiculo);
	}

}
