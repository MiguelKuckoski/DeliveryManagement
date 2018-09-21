package controle;

import entidade.Veiculo;
import persistencia.VeiculoDAO;

public class ControleVeiculo {

	private VeiculoDAO veiculoDAO = new VeiculoDAO();

	public VeiculoDAO getVeiculoDAO() {
		return veiculoDAO;
	}

	public void setVeiculoDAO(VeiculoDAO veiculoDAO) {
		this.veiculoDAO = veiculoDAO;
	}

	public ControleVeiculo() {
		this.veiculoDAO = new VeiculoDAO();
	}

	public void cadastrarVeiculo(String marca, String modelo, String placa, int ano, String tipo) {
		Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, tipo);
		veiculoDAO.put(veiculo);
	}

}
