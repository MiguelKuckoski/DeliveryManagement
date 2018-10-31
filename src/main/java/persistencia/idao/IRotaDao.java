package persistencia.idao;

import java.util.Map;

import entidade.Rota;

public interface IRotaDao {

	public void inserir(Rota veiculo);
	public Map<String, Rota> listar();
	public void atualizar(Rota veiculo, String id);
	public void remover(Rota veiculo);
}
