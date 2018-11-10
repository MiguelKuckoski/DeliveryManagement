package persistencia.idao;

import java.util.Map;

import entidade.Motorista;
import entidade.Veiculo;

public interface IVeiculoDao {
	
	public boolean inserir(String placa, Veiculo veiculo);
	
	public Map<String, Veiculo> listar();
	
	public boolean atualizar(String placa, Veiculo veiculo);
	
	public boolean remover(String placa);
	
	public void vincularMotorista(String placa, Motorista motorista);
	
	public void desvincularMotorista(String placa, Motorista motorista);
	
}
