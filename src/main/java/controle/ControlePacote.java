package controle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
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

	public String cadastrarPacote(String nomeRemetente, String nomeDestino, String codLocalizador, String endRemetente,
			String endDestino, Double peso) {
		if (listarTodosPacotes().containsKey(codLocalizador)) {
			return "CodLocalizador já cadastrado - Digite outro ou deixe em branco para gerar automaticamente";
		} else {
			if (codLocalizador.isEmpty()) {
				codLocalizador = String.valueOf(new Random().nextInt(10000) + 1);
			}
			Pacote pacote = new Pacote(nomeRemetente, nomeDestino, codLocalizador, endRemetente, endDestino, peso);
			pacoteDAO.inserir(pacote);
			return "Pacote cadastrado com sucesso";
		}

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

	public Map<String, Pacote> listarTodosPacotes() {
		Map<String, Pacote> listaTodosPacotes = new HashMap<String, Pacote>();

		Set<String> chaves = pacoteDAO.listar().keySet();

		for (String chave : chaves) {
			Pacote pacote = pacoteDAO.listar().get(chave);
			listaTodosPacotes.put(pacote.getCodLocalizador(), pacote);
		}
		return listaTodosPacotes;
	}

	public void atualizarPacote(Pacote pacote, String codRastreio) {
		pacoteDAO.atualizar(pacote, codRastreio);
	}

	public void removerPacote(Pacote pacote) {
		if (!pacoteDAO.remover(pacote)) {
			JOptionPane.showMessageDialog(null, "Erro ao remover pacote", "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}
}
