package persistencia.idao;

import java.util.Map;

import entidade.Pacote;

public interface IPacoteDao {

	public void inserir(Pacote pacote);

	public Map<String, Pacote> listar();

	public void atualizar(Pacote pacote, String codLocalizador);

	public boolean remover(Pacote pacote);
}
