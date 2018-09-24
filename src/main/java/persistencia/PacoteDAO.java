package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import entidade.Pacote;

public class PacoteDAO {
	private static final String FILE_PATH = "arquivos/pacote.dat";
	private HashMap<String, Pacote> listaPacote;

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
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listaPacote = (HashMap<String, Pacote>) ois.readObject();

			ois.close();
			fis.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Erro ao abrir o arquivo " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro de entrada ou saida de dados " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.err.println("Erro ao processar registros dos arquivos " + FILE_PATH);
			System.err.println(ex.getMessage());
		}
	}

	public void persist() {

		try {
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaPacote);

			oos.flush();
			fos.flush();

			oos.close();
			fos.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Arquivo n�o encontrado " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro na entrada e saida de dados " + FILE_PATH);
			System.err.println(ex.getMessage());
		}

	}

	public HashMap<String, Pacote> getListaPacote() {
		return listaPacote;
	}

	public void setListaPacote(HashMap<String, Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}
}
