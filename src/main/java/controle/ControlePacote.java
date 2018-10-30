package controle;

import entidade.Pacote;
import persistencia.DaoFactory;
import persistencia.idao.IPacoteDao;

public class ControlePacote {

	private IPacoteDao pacoteDAO;

	public ControlePacote(String persistencia) {
		this.pacoteDAO = DaoFactory.getPacoteDAO(persistencia);
	}

	public void cadastrarPacote(String nomeRemetente, String nomeDestino, String codLocalizador, String endRemetente,
			String endDestino, Double peso) {
		Pacote pacote = new Pacote(nomeRemetente, nomeDestino, codLocalizador, endRemetente, endDestino, peso);
		pacoteDAO.inserir(pacote);
	}

}
