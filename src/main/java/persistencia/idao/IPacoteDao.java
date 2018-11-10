package persistencia.idao;

import java.util.Map;

import entidade.Pacote;

public interface IPacoteDao {
	
	public boolean inserir(Pacote pacote);
	public Map<String, Pacote> listar();
	public boolean atualizar(Pacote pacote, String id);
	public boolean remover(Pacote pacote);
}
