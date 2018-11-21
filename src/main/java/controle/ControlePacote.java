package controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.swing.JOptionPane;

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

	public Map<String, Pacote> listarPacotesNaoEntregues() {
		Map<String, Pacote> listaPacoteNaoentregue = new HashMap<String, Pacote>();

		Set<String> chaves = pacoteDAO.listar().keySet();

		for (String chave : chaves) {
			Pacote pacote = pacoteDAO.listar().get(chave);
			if (!pacote.isEntrega()) {
				listaPacoteNaoentregue.put(pacote.getCodLocalizador(), pacote);
			}
		}
		return listaPacoteNaoentregue;
	}

	public Map<String, Pacote> listarPacotesEntregues() {
		Map<String, Pacote> listaPacotesEntregues = new HashMap<String, Pacote>();

		Set<String> chaves = pacoteDAO.listar().keySet();

		for (String chave : chaves) {
			Pacote pacote = pacoteDAO.listar().get(chave);
			if (pacote.isEntrega()) {
				listaPacotesEntregues.put(pacote.getCodLocalizador(), pacote);
			}
		}
		return listaPacotesEntregues;
	}

	public Map<String, Pacote> listarPacotesNaoRoteirizados() {
		Map<String, Pacote> listaPacotesNaoRoteirizados = new HashMap<String, Pacote>();

		Set<String> chaves = pacoteDAO.listar().keySet();

		for (String chave : chaves) {
			Pacote pacote = pacoteDAO.listar().get(chave);
			if (!pacote.isEntrega() && !pacote.isRoteirizado()) {
				listaPacotesNaoRoteirizados.put(pacote.getCodLocalizador(), pacote);
			}
		}
		return listaPacotesNaoRoteirizados;
	}

	public void atualizarPacote(Pacote pacote, String codRastreio) {
		pacoteDAO.atualizar(pacote, codRastreio);
	}

	public void removerPacote(Pacote pacote) {
		if(!pacoteDAO.remover(pacote)) {
			JOptionPane.showMessageDialog(null, "Erro ao remover pacote", "Erro" ,JOptionPane.ERROR_MESSAGE);
		}
	}
}
