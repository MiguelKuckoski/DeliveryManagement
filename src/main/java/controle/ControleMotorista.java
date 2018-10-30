package controle;

import entidade.Motorista;
import persistencia.file.MotoristaFileDAO;

public class ControleMotorista {

	private MotoristaFileDAO motoristaDAO;

	public ControleMotorista() {

		this.motoristaDAO = new MotoristaFileDAO();
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

	public MotoristaFileDAO getMotoristaDAO() {
		return motoristaDAO;
	}

	public void setMotoristaDAO(MotoristaFileDAO motoristaDAO) {
		this.motoristaDAO = motoristaDAO;
	}

}
