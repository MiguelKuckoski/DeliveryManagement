package persistencia.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.idao.IVeiculoDao;

public class VeiculoFileDAO implements IVeiculoDao {

	private static final String FILE_PATH = "arquivos/veiculos.dat";
	private Map<String, Veiculo> listaVeiculo;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;

	public VeiculoFileDAO() {
		listaVeiculo = new HashMap<String, Veiculo>();
		load();
	}

	public void put(String placa, Veiculo veiculo) {
		listaVeiculo.put(placa, veiculo);
		persist();
	}

	@SuppressWarnings("unchecked")
	private void load() {

		try {
			fis = new FileInputStream(FILE_PATH);
			ois = new ObjectInputStream(fis);

			listaVeiculo = (HashMap<String, Veiculo>) ois.readObject();

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

			oos.writeObject(listaVeiculo);

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

	public Map<String, Veiculo> getListaVeiculo() {
		return listaVeiculo;
	}

	public void setListaVeiculo(Map<String, Veiculo> listaVeiculo) {
		this.listaVeiculo = listaVeiculo;
	}

	@Override
	public boolean inserir(String placa, Veiculo veiculo) {

		if (veiculo != null) {
			if (!veiculo.getPlaca().isEmpty() && !listaVeiculo.containsKey(veiculo.getPlaca())) {
				put(veiculo.getPlaca(), veiculo);
				return true;
			}
		}
		return false;
	}

	@Override
	public Map<String, Veiculo> listar() {
		return getListaVeiculo();
	}

	@Override
	public boolean atualizar(String placa, Veiculo veiculo) {
		if (veiculo != null) {
			if (listaVeiculo.containsKey(placa)) {
				listaVeiculo.get(placa).setAno(veiculo.getAno());
				listaVeiculo.get(placa).setMarca(veiculo.getMarca());
				listaVeiculo.get(placa).setModelo(veiculo.getModelo());
				listaVeiculo.get(placa).setTipo(veiculo.getTipo());
				listaVeiculo.get(placa).setMotorista(veiculo.getMotorista());
				persist();
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean remover(String placa) {

		if (getListaVeiculo().containsKey(placa)) {
			getListaVeiculo().remove(placa);
			persist();
			return true;
		}
		return false;
	}

	@Override
	public void vincularMotorista(String placa, Motorista motorista) {
		listaVeiculo.get(placa).vincularMotorista(motorista);
		persist();
	}

	@Override
	public void desvincularMotorista(String placa, Motorista motorista) {
		listaVeiculo.get(placa).desvincularMotorista(motorista);
		persist();
	}

}
