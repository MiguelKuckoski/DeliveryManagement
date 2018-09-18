package controle;

import entidade.Pacote;
import entidade.Veiculo;
import persistencia.VeiculoDAO;

public class ControleVeiculo {

	private VeiculoDAO veiculoDAO;

	public VeiculoDAO getVeiculoDAO() {
		return veiculoDAO;
	}

	public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	public ControleVeiculo() {
		this.veiculoDAO = new VeiculoDAO();
	}

	public void cadastrarVeiculo(String marca, String modelo, int ano, String placa, Pacote listaDePacote[], int tipo) {

		// if (tipo == 1) {
		////
		//// Veiculo veiculo = new Carreta(marca, modelo, placa, ano, listaDePacote);
		////
		//// } else if (tipo == 2) {
		////
		//// } else if (tipo == 3) {
		////
		//// }

		Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, listaDePacote);
		veiculoDAO.put(veiculo);
	}

}
