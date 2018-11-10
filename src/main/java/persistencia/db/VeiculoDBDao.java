package persistencia.db;

import java.util.Map;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.idao.IVeiculoDao;

public class VeiculoDBDao implements IVeiculoDao{

	@Override
	public Map<String, Veiculo> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean inserir(String placa, Veiculo veiculo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void atualizar(String placa, Veiculo veiculo) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean remover(String placa) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void vincularMotorista(String placa, Motorista motorista) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void desvincularMotorista(String placa, Motorista motorista) {
		// TODO Auto-generated method stub
		
	}

}
