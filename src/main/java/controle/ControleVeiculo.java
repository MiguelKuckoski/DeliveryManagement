package controle;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.MotoristaDAO;
import persistencia.VeiculoDAO;

public class ControleVeiculo {

	private VeiculoDAO veiculoDAO = new VeiculoDAO();
	private MotoristaDAO motoristaDAO = new MotoristaDAO();

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

	public void vincularMotorista(String placaVeiculo, String cnhMotorista) {

		Motorista motorista = null;
		Veiculo veiculo;

		for (Motorista motoristas : motoristaDAO.getListaMotorista()) {
			if (motoristas.equals(cnhMotorista)) {
				motorista = motoristas;
			}
		}

		for (Veiculo veiculos : veiculoDAO.getListaVeiculo()) {
			if (veiculos.equals(placaVeiculo)) {
				veiculos.vincularMotorista(motorista);
			}
		}

	}

}
