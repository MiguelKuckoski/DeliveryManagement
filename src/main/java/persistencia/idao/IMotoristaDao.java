package persistencia.idao;

import java.util.Map;

import entidade.Motorista;

public interface IMotoristaDao {

	public boolean inserir(Motorista motorista);

	public Map<String, Motorista> listar();

	public void atualizar(String cnhNum, Motorista motorista);

	public boolean remover(String cnhNum);

}
