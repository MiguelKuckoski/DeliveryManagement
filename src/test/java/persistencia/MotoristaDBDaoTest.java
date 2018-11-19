package persistencia;

import java.util.Map;

import org.junit.jupiter.api.Test;

import entidade.Motorista;
import persistencia.db.MotoristaDBDao;

class MotoristaDBDaoTest {

	@Test
	void inserirTest() {
		MotoristaDBDao dao= new MotoristaDBDao();
		Motorista motorista = new Motorista();
		motorista.setCnhNum("23455");
		motorista.setCnhTipo("B");
		motorista.setEndereco("Capoeiras");
		motorista.setNascimento("13/02/1998");
		motorista.setNome("Miguel Kuckoski");
		motorista.setVinculadoCarro(false);
		dao.inserir(motorista);
	}

	@Test
	void atualizarTest() {
		MotoristaDBDao dao= new MotoristaDBDao();
		Motorista motorista = new Motorista();
		motorista.setCnhNum("5664");
		motorista.setCnhTipo("C");
		motorista.setEndereco("Itacorubi");
		motorista.setNascimento("13/02/1990");
		motorista.setNome("Miguel Freitas");
		motorista.setVinculadoCarro(true);
		
		dao.atualizar("23455", motorista);
	}
	
	@Test
	void listarTest() {
		MotoristaDBDao dao= new MotoristaDBDao();
		Map<String, Motorista> motoristas = dao.listar();
		motoristas.toString();
	}
	
	@Test
	void removeTest() {
		MotoristaDBDao dao= new MotoristaDBDao();
		Motorista motorista = new Motorista();
		motorista.setCnhNum("5664");
		dao.remover(motorista);
	}
	
}
