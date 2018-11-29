package persistencia.idao;

import java.util.List;
import java.util.Map;

import entidade.Rota;

public interface IRotaDao {

	public void inserir(List<Rota> rotas);
	public Map<String, List<Rota>> pesquisar(String motorista, String data);
	public void remover(Rota veiculo);
	public Rota rotaDetalhada(String data, String veiculoPlaca);
}
