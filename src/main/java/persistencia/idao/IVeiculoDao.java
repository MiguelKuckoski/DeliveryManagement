package persistencia.idao;

import java.util.Map;

import entidade.Veiculo;

public interface IVeiculoDao {

	public void inserir(Veiculo veiculo);
	public Map<String, Veiculo> listar();
	public void atualizar(Veiculo veiculo, String id);
	public void remover(Veiculo veiculo);
}
