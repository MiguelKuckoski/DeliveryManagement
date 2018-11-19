package persistencia;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import entidade.Pacote;
import entidade.Rota;
import entidade.Veiculo;
import persistencia.db.RotaDBDao;

class RotaDBDaoTeste {

	@Test
	void inserirTest() {
		RotaDBDao dao = new RotaDBDao();
		
		List<Pacote> lp1 = new ArrayList<>();
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ghu-7676");
		Pacote p1 = new Pacote();
		p1.setCodLocalizador("2");
		lp1.add(p1);
		veiculo.setListaDePacote(lp1);
		List<Pacote> lp2 = new ArrayList<>();
		Veiculo v2 = new Veiculo();
		v2.setPlaca("dsu-2837");
		Pacote p2 = new Pacote();
		p2.setCodLocalizador("5");
		lp2.add(p2);
		Rota r1 = new Rota();
		r1.setVeiculo(veiculo);
		r1.setDataExecucao("20/11/2018");
		Rota r2 = new Rota();
		r2.setVeiculo(v2);
		r2.setDataExecucao("20/12/2018");
		List<Rota> rotas = new ArrayList<>();
		rotas.add(r1);
		rotas.add(r2);
		
		dao.inserir(rotas);
	}
}
