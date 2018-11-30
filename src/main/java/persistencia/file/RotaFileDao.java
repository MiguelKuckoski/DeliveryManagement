package persistencia.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import entidade.Rota;
import persistencia.idao.IRotaDao;

public class RotaFileDao implements IRotaDao {
	private static final String FILE_PATH = "arquivos/rota.dat";
	private Map<String, List<Rota>> listaRota;
	private FileInputStream fis = null;
	private ObjectInputStream ois = null;
	private FileOutputStream fos = null;
	private ObjectOutputStream oos = null;

	public RotaFileDao() {
		setListaRota(new HashMap<String, List<Rota>>());
		load();
	}

	private void load() {
		try {
			fis = new FileInputStream(FILE_PATH);
			ois = new ObjectInputStream(fis);
			setListaRota((HashMap<String, List<Rota>>) ois.readObject());
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
			oos.writeObject(listaRota);
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

	@Override
	public void inserir(List<Rota> rotas) {
		try {
			if (rotas != null && !rotas.isEmpty()) {
				listaRota.put(rotas.get(0).getDataExecucao(), rotas);
				persist();
			} else {
				throw new Exception("Nenhuma rota para ser inserida.");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Map<String, List<Rota>> pesquisar(String motorista, String data) {
		Map<String, List<Rota>> mapRotas = new HashMap<>();
		List<Rota> listRota = new ArrayList<>();

		if (motorista != null && data != null) {
			getListaRota().get(data).parallelStream().forEach(rota -> {
				if (motorista.equalsIgnoreCase((rota.getVeiculo().getMotorista().getCnhNum()))) {
					listRota.add(rota);
				}
			});

			mapRotas.put(data, listRota);
		} else if (motorista != null) {
			Iterator<String> keys = getListaRota().keySet().iterator();
			String key;
			while (keys.hasNext()) {
				key = keys.next();

				getListaRota().get(key).parallelStream().forEach(rota -> {
					if (motorista.equalsIgnoreCase(rota.getVeiculo().getMotorista().getCnhNum())) {
						if (mapRotas.containsKey(rota.getDataExecucao())) {
							mapRotas.get(rota.getDataExecucao()).add(rota);
						} else {
							listRota.add(rota);
							mapRotas.put(rota.getDataExecucao(), listRota);
							listRota.clear();
						}
					}
				});
			}
		} else if (data != null) {
			mapRotas.put(data, getListaRota().get(data));
		}

		return mapRotas;
	}

	@Override
	public void remover(Rota rota) {
		if (listaRota.containsKey(rota.getDataExecucao())) {
			listaRota.remove(rota.getDataExecucao());
			persist();
		}
	}

	@Override
	public Rota rotaDetalhada(String data, String veiculoPlaca) {
		for (Rota rota : getListaRota().get(data)) {
			if (veiculoPlaca.equalsIgnoreCase(rota.getVeiculo().getPlaca())) {
				return rota;
			}
		}

		return null;
	}

	public Map<String, List<Rota>> getListaRota() {
		return listaRota;
	}

	public void setListaRota(Map<String, List<Rota>> listaRota) {
		this.listaRota = listaRota;
	}

}
