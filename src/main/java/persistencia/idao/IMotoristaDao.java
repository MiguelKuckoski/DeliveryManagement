package persistencia.idao;

import java.util.Map;

import entidade.Motorista;

public interface IMotoristaDao {
	
	public void inserir(Motorista motorista);
	public Map<String, Motorista> listar();
	public void atualizar(Motorista motorista, String id);
	public void remover(Motorista motorista);

}
