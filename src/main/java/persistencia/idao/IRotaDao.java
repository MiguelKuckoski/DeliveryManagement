package persistencia.idao;

import java.util.List;
import java.util.Map;

import entidade.Rota;

public interface IRotaDao {

	public void inserir(List<Rota> rotas);
	public Map<String, List<Rota>> listar();
	public void atualizar(Rota veiculo, String id);
	public void remover(Rota veiculo);
}
