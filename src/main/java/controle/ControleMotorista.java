package controle;

import entidade.Motorista;
import persistencia.DaoFactory;
import persistencia.file.MotoristaFileDAO;
import persistencia.idao.IMotoristaDao;

public class ControleMotorista {

	private IMotoristaDao motoristaDAO;

	public ControleMotorista(String persistencia) {

		this.motoristaDAO = DaoFactory.getMotoristaDAO(persistencia);
	}

	public void cadastrarMotorista(String nome, String nascimento, String endereco, String cnhNum, String cnhTipo) {

		Motorista motorista = new Motorista(nome, nascimento, endereco, cnhNum, cnhTipo);
		motoristaDAO.put(cnhNum,motorista);

	}
	
	public String removerMotorista(String cnhNum) {
		if(motoristaDAO.getListaMotorista().containsKey(cnhNum)) {
			motoristaDAO.getListaMotorista().remove(cnhNum);
			motoristaDAO.persit();
			return "Motorista apagado com sucesso";
		}
		
		return "Erro ao apagar motorista/Motorista não encontrado";
	}
}
