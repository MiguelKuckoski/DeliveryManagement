package controle;

import entidade.Endereco;
import entidade.Motorista;
import persistencia.MotoristaDAO;

public class ControleMotorista {

	private MotoristaDAO motoristaDAO;

	public ControleMotorista() {

		this.motoristaDAO = new MotoristaDAO();
	}

	public void cadastrarMotorista(String nome, String nascimento, Endereco endereco, String cnhNum, String cnhTipo) {

		Motorista motorista = new Motorista(nome, nascimento, endereco, cnhNum, cnhTipo);
		motoristaDAO.put(motorista);

	}

	public MotoristaDAO getMotoristaDAO() {
		return motoristaDAO;
	}

	public void setMotoristaDAO(MotoristaDAO motoristaDAO) {
		this.motoristaDAO = motoristaDAO;
	}

}
