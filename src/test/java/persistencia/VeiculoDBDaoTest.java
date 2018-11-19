package persistencia;

import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.db.VeiculoDBDao;

class VeiculoDBDaoTest{

	@Test
	void inserirTest() {
		VeiculoDBDao dao = new VeiculoDBDao();
		Veiculo veiculo = new Veiculo();
		veiculo.setAno(1123);
		veiculo.setMarca("teste");
		veiculo.setModelo("fusca");
		veiculo.setPlaca("dsu-7676");
		veiculo.setTipo(1);
		veiculo.setMotorista(new Motorista());
		
		dao.inserir(veiculo.getPlaca(), veiculo);
	}
	
	@Test
	void atualizarTest() {
		VeiculoDBDao dao = new VeiculoDBDao();		
		Veiculo veiculo = new Veiculo();
		veiculo.setAno(2092);
		veiculo.setMarca("Renault");
		veiculo.setModelo("Sandero");
		veiculo.setPlaca("dsu-2837");
		veiculo.setTipo(2);
		
		dao.atualizar(veiculo.getPlaca(), veiculo);
	}
	
	@Test
	void removerTest() {
		VeiculoDBDao dao = new VeiculoDBDao();
		dao.remover("dsu-7676");
	}
		
	@Test
	void listar() {
		VeiculoDBDao dao = new VeiculoDBDao();		
		Map<String, Veiculo> veiculos = dao.listar();
		System.out.println(veiculos.toString());
	}

	@Test
	void vincularMotoristaTeste() {
		VeiculoDBDao dao = new VeiculoDBDao();		
		Motorista motorista = new Motorista();
		motorista.setCnhNum("29282");
		dao.vincularMotorista("dsu-2837", motorista);
	}
	
	@Test
	void DesvincularMotoristaTeste() {
		VeiculoDBDao dao = new VeiculoDBDao();	
		dao.desvincularMotorista("dsu-2837");
	}
}
