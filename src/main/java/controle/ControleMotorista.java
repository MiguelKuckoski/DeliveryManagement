package controle;

import entidade.Motorista;
import persistencia.MotoristaDAO;

public class ControleMotorista {

	private MotoristaDAO motoristaDAO;

	public ControleMotorista() {

		this.motoristaDAO = new MotoristaDAO();
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

	public MotoristaDAO getMotoristaDAO() {
		return motoristaDAO;
	}

	public void setMotoristaDAO(MotoristaDAO motoristaDAO) {
		this.motoristaDAO = motoristaDAO;
	}

}
