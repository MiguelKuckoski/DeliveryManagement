package persistencia.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import entidade.Pacote;
import persistencia.idao.IPacoteDao;

public class PacoteFileDAO implements IPacoteDao {
	private static final String FILE_PATH = "arquivos/pacote.dat";
	private Map<String, Pacote> listaPacote;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;

	public PacoteFileDAO() {
		listaPacote = new HashMap<String, Pacote>();
		load();
	}

	@SuppressWarnings("unchecked")
	private void load() {

		try {
			fis = new FileInputStream(FILE_PATH);
			ois = new ObjectInputStream(fis);

			listaPacote = (HashMap<String, Pacote>) ois.readObject();

		} catch (FileNotFoundException ex) {
			System.err.println("Erro ao abrir o arquivo " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro de entrada ou saida de dados " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.err.println("Erro ao processar registros dos arquivos " + FILE_PATH);
			System.err.println(ex.getMessage());
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
				if (fis != null) {
					fis.close();
				}
			} catch (Exception e) {

			}
		}
	}

	public void persist() {

		try {
			fos = new FileOutputStream(FILE_PATH);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listaPacote);

			oos.flush();
			fos.flush();

		} catch (FileNotFoundException ex) {
			System.err.println("Arquivo não encontrado " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro na entrada e saida de dados " + FILE_PATH);
			System.err.println(ex.getMessage());
		} finally {
			try {
				if (oos != null) {
					oos.close();
				}
				if (fos != null) {
					fos.close();
				}
			} catch (Exception e) {

			}
		}

	}

	public void setListaPacote(Map<String, Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}

	@Override
	public void inserir(Pacote pacote) {
		listaPacote.put(pacote.getCodLocalizador(), pacote);
		persist();
	}

	@Override
	public Map<String, Pacote> listar() {
		return listaPacote;
	}

	@Override
	public void atualizar(Pacote pacote, String codLocalizador) {
		if (pacote != null) {
			if (listaPacote.containsKey(codLocalizador)) {
				listaPacote.put(codLocalizador, pacote);
				persist();
			}
		}
	}

	@Override
	public boolean remover(Pacote pacote) {
		if (listaPacote.containsKey(pacote.getCodLocalizador())) {
			listaPacote.remove(pacote.getCodLocalizador());
			persist();
			return true;
		}
		return false;
	}
}
