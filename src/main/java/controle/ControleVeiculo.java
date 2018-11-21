package controle;

import java.util.Map;

import entidade.Veiculo;
import persistencia.DaoFactory;
import persistencia.idao.IMotoristaDao;
import persistencia.idao.IVeiculoDao;

public class ControleVeiculo {

	private IVeiculoDao veiculoDAO;
	private IMotoristaDao motoristaDAO;

	public ControleVeiculo(String persistencia) {
		this.veiculoDAO = DaoFactory.getVeiculoDAO(persistencia);
		this.motoristaDAO = DaoFactory.getMotoristaDAO(persistencia);
	}

	public boolean cadastrarVeiculo(String marca, String modelo, String placa, int ano, int tipo) {
		Veiculo veiculo = new Veiculo(marca, modelo, placa, ano, tipo);

		return veiculoDAO.inserir(placa, veiculo);
	}

	public String desvincularMotorista(String placaVeiculo) {
		if (veiculoDAO.listar().containsKey(placaVeiculo)) {
			if (veiculoDAO.listar().get(placaVeiculo).getMotorista() != null) {
				String cnhMotorista = veiculoDAO.listar().get(placaVeiculo).getMotorista().getCnhNum();
				if (veiculoDAO.listar().get(placaVeiculo)
						.desvincularMotorista(veiculoDAO.listar().get(placaVeiculo).getMotorista())) {
					motoristaDAO.listar().get(cnhMotorista).setVinculadoCarro(false);
					veiculoDAO.desvincularMotorista(placaVeiculo, motoristaDAO.listar().get(cnhMotorista));
					motoristaDAO.atualizar(motoristaDAO.listar().get(cnhMotorista).getCnhNum(),
							motoristaDAO.listar().get(cnhMotorista));
					return "Removido com sucesso";
				} else {
					return "Erro ao remover";
				}
			} else {
				return "Veiculo sem motorista ja vinculado";
			}
		} else {
			return "Placa ou Cnh não existe OU Sem motorista vinculado";
		}
	}

	public Map<String, Veiculo> listarVeiculos() {
		return veiculoDAO.listar();
	}

	public void atualizarVeiculo(String placa, Veiculo veiculo) {
		veiculoDAO.atualizar(placa, veiculo);
	}

	public String removerVeiculo(String placa) {
		if (veiculoDAO.remover(placa)) {
			return "Veiculo apagado com sucesso";
		}
		return "Veiculo não encontrado";
	}

	public String vincularMotorista(String placaVeiculo, String cnhMotorista) {
		if (veiculoDAO.listar().containsKey(placaVeiculo) && motoristaDAO.listar().containsKey(cnhMotorista)
				&& !motoristaDAO.listar().get(cnhMotorista).getVinculadoCarro()) {
			if (veiculoDAO.listar().get(placaVeiculo).getMotorista() == null) {

				if (veiculoDAO.listar().get(placaVeiculo).vincularMotorista(motoristaDAO.listar().get(cnhMotorista))) {
					motoristaDAO.listar().get(cnhMotorista).setVinculadoCarro(true);
					veiculoDAO.vincularMotorista(placaVeiculo, motoristaDAO.listar().get(cnhMotorista));
					motoristaDAO.atualizar(motoristaDAO.listar().get(cnhMotorista).getCnhNum(),
							motoristaDAO.listar().get(cnhMotorista));
					return "Vinculado com sucesso";
				} else {
					return "Motorista com CNH não permitida para o veículo";
				}

			} else {
				return "Veiculo com motorista ja vinculado";
			}
		} else {
			return "Placa ou Cnh não existe OU Motorista ja vinculado";
		}
	}

}
