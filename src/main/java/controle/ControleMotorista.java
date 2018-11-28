package controle;

import java.util.Map;

import entidade.Motorista;
import persistencia.DaoFactory;
import persistencia.idao.IMotoristaDao;

public class ControleMotorista {

	private final IMotoristaDao motoristaDAO;

	public ControleMotorista(String persistencia) {

		this.motoristaDAO = DaoFactory.getMotoristaDAO(persistencia);
	}

	public boolean cadastrarMotorista(String nome, String nascimento, String endereco, String cnhNum, String cnhTipo) {

		Motorista motorista = new Motorista(nome, nascimento, endereco, cnhNum, cnhTipo);

		return motoristaDAO.inserir(motorista);
	}

	public String removerMotorista(String cnhNum) {

		if (motoristaDAO.remover(cnhNum)) {
			return "Motorista apagado com sucesso";
		} else {
			return "Erro ao apagar motorista/Motorista não encontrado";
		}
	}

	public void atualizarMotorista(String cnhNum, Motorista motorista) {
		motoristaDAO.atualizar(cnhNum, motorista);
	}

	public Map<String, Motorista> listarMotoristas() {
		return motoristaDAO.listar();
	}
}
