package persistencia;

import java.util.Map;


import entidade.Pacote;
import persistencia.db.PacoteDBDao;

class PacoteDBDaoTest {

	@Test
	void inserirTest() {
		PacoteDBDao dao= new PacoteDBDao();
		Pacote pacote = new Pacote();
		pacote.setCodLocalizador("8");
		pacote.setEndDestino("Capoeiras");
		pacote.setEndRemetente("Itacorubi");
		pacote.setNomeDestino("Miguel");
		pacote.setNomeRemetente("Thalissa");
		pacote.setPeso(18);
		dao.inserir(pacote);
	}

	@Test
	void atualizarTest() {
		PacoteDBDao dao= new PacoteDBDao();
		Pacote pacote = new Pacote();
		pacote.setCodLocalizador("9");
		pacote.setEndDestino("Itacorubi");
		pacote.setEndRemetente("Capoeiras");
		pacote.setNomeDestino("Miguel");
		pacote.setNomeRemetente("Thalissa");
		pacote.setRoteirizado(true);
		pacote.setEntrega(true);
		pacote.setPeso(18);
		dao.atualizar(pacote, "9");
	}
	
	@Test
	void listarTest() {
		PacoteDBDao dao= new PacoteDBDao();
		Map<String, Pacote> pacotes = dao.listar();
		pacotes.toString();
	}
	
	@Test
	void removeTest() {
		PacoteDBDao dao= new PacoteDBDao();
		Pacote pacote = new Pacote();
		pacote.setCodLocalizador("9");
		pacote.setEndDestino("Itacorubi");
		pacote.setEndRemetente("Capoeiras");
		pacote.setNomeDestino("Miguel");
		pacote.setNomeRemetente("Thalissa");
		pacote.setRoteirizado(true);
		pacote.setEntrega(true);
		pacote.setPeso(18);
		dao.remover(pacote);
	}
	
}
