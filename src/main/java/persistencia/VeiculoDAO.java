package persistencia;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashSet;

import entidade.Veiculo;

public class VeiculoDAO {

	private static final String FILE_PATH = "arquivos/veiculos.dat";
	private HashSet<Veiculo> listaVeiculo;

	public VeiculoDAO() {
		listaVeiculo = new HashSet<Veiculo>();
		load();
	}

	public void put(Veiculo veiculo) {
		listaVeiculo.add(veiculo);
		persist();
	}

	@SuppressWarnings("unchecked")
	private void load() {

		try {
			FileInputStream fis = new FileInputStream(FILE_PATH);
			ObjectInputStream ois = new ObjectInputStream(fis);

			listaVeiculo = (HashSet<Veiculo>) ois.readObject();

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

			oos.writeObject(listaVeiculo);

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

	public HashSet<Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(HashSet<Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

}
