package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import entidade.Pacote;

public class PacoteDAO {
	private static final String FILE_PATH = "arquivos/pacote.dat";
	private Map<String, Pacote> listaPacote;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;

	public PacoteDAO() {
		listaPacote = new HashMap<String, Pacote>();
		load();
	}

	public void put(String codLocalizador, Pacote pacote) {
		listaPacote.put(codLocalizador, pacote);
		persist();
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

	public Map<String, Pacote> getListaPacote() {
		return listaPacote;
	}

	public void setListaPacote(Map<String, Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}
}
