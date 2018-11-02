package controle;

import java.util.Map;

import entidade.Motorista;
import persistencia.DaoFactory;
import persistencia.idao.IMotoristaDao;

public class ControleMotorista {

	private IMotoristaDao motoristaDAO;

	public ControleMotorista(String persistencia) {

		this.motoristaDAO = DaoFactory.getMotoristaDAO(persistencia);
	}

	public boolean cadastrarMotorista(String nome, String nascimento, String endereco, String cnhNum, String cnhTipo) {

		Motorista motorista = new Motorista(nome, nascimento, endereco, cnhNum, cnhTipo);

		if (motoristaDAO.inserir(motorista)) {
			return true;
		} else {
			return false;
		}

		// motoristaDAO.put(cnhNum,motorista);

	}

	public String removerMotorista(String cnhNum) {

		if (motoristaDAO.remover(cnhNum)) {
			return "Motorista apagado com sucesso";
		} else {
			return "Erro ao apagar motorista/Motorista não encontrado";
		}

		// if(motoristaDAO.getListaMotorista().containsKey(cnhNum)) {
		// motoristaDAO.getListaMotorista().remove(cnhNum);
		// motoristaDAO.persit();
		// return "Motorista apagado com sucesso";
		// }
		//
		// return "Erro ao apagar motorista/Motorista não encontrado";
	}

	public void atualizarMotorista(String cnhNum, Motorista motorista) {
		motoristaDAO.atualizar(cnhNum, motorista);
	}

	public Map<String, Motorista> listarMotoristas() {
		return motoristaDAO.listar();
	}
}
