package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import entidade.Pacote;

public class PacoteDAO {
	private static final String FILE_PATH = "arquivos/pacote.dat";
	private HashSet<Pacote> listaPacote;

	public PacoteDAO() {
		listaPacote = new HashSet<Pacote>();
		load();
	}

	public void put(Pacote pacote) {
		listaPacote.add(pacote);
		persit();
	}

	private void load() {

		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listaPacote = (HashSet<Pacote>) ois.readObject();

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

	public void persit() {

		try {
			FileOutputStream fos = new FileOutputStream(FILE_PATH);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaPacote);

			oos.flush();
			fos.flush();

			oos.close();
			fos.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Arquivo não encontrado " + FILE_PATH);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro na entrada e saida de dados " + FILE_PATH);
			System.err.println(ex.getMessage());
		}

	}

	public HashSet<Pacote> getListaPacote() {
		return listaPacote;
	}

	public void setListaPacote(HashSet<Pacote> listaPacote) {
		this.listaPacote = listaPacote;
	}

}
