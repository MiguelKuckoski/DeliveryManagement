package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;

import entidade.Motorista;

public class MotoristaDAO {

	private static final String nomeArquivo = "arquivos/motorista.dat";
	private HashMap<String,Motorista> listaMotorista;

	public MotoristaDAO() {
		listaMotorista = new HashMap<String ,Motorista>();
		load();
		
	}

	public void put(String cnh ,Motorista motorista) {

		listaMotorista.put(cnh, motorista);
		persit();
	}

	@SuppressWarnings("unchecked")
	private void load() {

		try {
			FileInputStream fis = new FileInputStream(nomeArquivo);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listaMotorista = (HashMap<String,Motorista>) ois.readObject();

			ois.close();
			fis.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
			System.err.println(ex.getMessage());
		}
	}

	public void persit() {

		try {
			FileOutputStream fos = new FileOutputStream(nomeArquivo);
			ObjectOutputStream oos = new ObjectOutputStream(fos);

			oos.writeObject(listaMotorista);

			oos.flush();
			fos.flush();

			oos.close();
			fos.close();

		} catch (FileNotFoundException ex) {
			System.err.println("Arquivo não encontrado " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro na entrada e saida de dados " + nomeArquivo);
			System.err.println(ex.getMessage());
		}

	}

	public HashMap<String, Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(HashMap<String, Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}



}
