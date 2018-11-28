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
import persistencia.idao.IMotoristaDao;

public class MotoristaFileDAO implements IMotoristaDao {

	private static final String nomeArquivo = "arquivos/motorista.dat";
	private Map<String, Motorista> listaMotorista;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;

	public MotoristaFileDAO() {
		listaMotorista = new HashMap<String, Motorista>();
		load();

	}

	public void put(String cnh, Motorista motorista) {

		listaMotorista.put(cnh, motorista);
		persit();
	}

	@SuppressWarnings("unchecked")
	private void load() {

		try {
			fis = new FileInputStream(nomeArquivo);
			ois = new ObjectInputStream(fis);

			listaMotorista = (Map<String, Motorista>) ois.readObject();

		} catch (FileNotFoundException ex) {
			System.err.println("Erro ao abrir o arquivo " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro de entrada ou saida de dados " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (ClassNotFoundException ex) {
			System.err.println("Erro ao processar registros dos arquivos " + nomeArquivo);
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

	public void persit() {

		try {
			fos = new FileOutputStream(nomeArquivo);
			oos = new ObjectOutputStream(fos);

			oos.writeObject(listaMotorista);

			oos.flush();
			fos.flush();

		} catch (FileNotFoundException ex) {
			System.err.println("Arquivo não encontrado " + nomeArquivo);
			System.err.println(ex.getMessage());
		} catch (IOException ex) {
			System.err.println("Erro na entrada e saida de dados " + nomeArquivo);
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

	public Map<String, Motorista> getListaMotorista() {
		return listaMotorista;
	}

	public void setListaMotorista(Map<String, Motorista> listaMotorista) {
		this.listaMotorista = listaMotorista;
	}

	@Override
	public boolean inserir(Motorista motorista) {
		if (motorista != null) {
			if (!motorista.getCnhNum().isEmpty() && !listaMotorista.containsKey(motorista.getCnhNum())) {
				put(motorista.getCnhNum(), motorista);
				return true;
			}
		}
		return false;
	}

	@Override
	public Map<String, Motorista> listar() {
		return getListaMotorista();
	}

	@Override
	public void atualizar(String cnhNum, Motorista motorista) {
		if (motorista != null) {
			if (getListaMotorista().containsKey(cnhNum)) {

				getListaMotorista().get(cnhNum).setCnhTipo(motorista.getCnhTipo());
				getListaMotorista().get(cnhNum).setEndereco(motorista.getEndereco());
				getListaMotorista().get(cnhNum).setNascimento(motorista.getNascimento());
				getListaMotorista().get(cnhNum).setNome(motorista.getNome());

				persit();
			}
		}
	}

	@Override
	public boolean remover(String cnhNum) {
		if (getListaMotorista().containsKey(cnhNum)) {
			getListaMotorista().remove(cnhNum);
			persit();
			return true;
		}
		return false;
	}
}
