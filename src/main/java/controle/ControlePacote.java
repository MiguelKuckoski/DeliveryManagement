package controle;

import entidade.Pacote;
import persistencia.PacoteDAO;

public class ControlePacote {

	private PacoteDAO pacoteDAO;

	public void cadastrarPacote(String nomeRemetente, String nomeDestino, String codLocalizador, String endRemetente,
			String endDestino, Double peso, int idInsercao) {

		Pacote pacote = new Pacote(nomeRemetente, nomeDestino, codLocalizador, endRemetente, endDestino, peso,
				idInsercao);
		pacoteDAO.put(pacote);
	}

	public PacoteDAO getPacoteDAO() {
		return pacoteDAO;
	}

	public void setPacoteDAO(PacoteDAO pacoteDAO) {
		this.pacoteDAO = pacoteDAO;
	}

}
