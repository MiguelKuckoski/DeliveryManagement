import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.junit.Test;

import controle.ControladorPrincipal;
import entidade.Pacote;
import entidade.Rota;
import entidade.Veiculo;
import persistencia.db.RotaDBDao;

public class RotaDBDaoTest {

	@Test
	public void inserirTest() {
		RotaDBDao dao = new RotaDBDao();
		
		List<Pacote> lp1 = new ArrayList<>();
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ghu-7676");
		Pacote p1 = new Pacote();
		p1.setCodLocalizador("5");
		lp1.add(p1);
		veiculo.setListaDePacote(lp1);
		List<Pacote> lp2 = new ArrayList<>();
		Veiculo v2 = new Veiculo();
		v2.setPlaca("dsu-2837");
		Pacote p2 = new Pacote();
		p2.setCodLocalizador("2");
		lp2.add(p2);
		v2.setListaDePacote(lp2);
		Rota r1 = new Rota();
		r1.setVeiculo(veiculo);
		r1.setDataExecucao("30/12/2018");
		Rota r2 = new Rota();
		r2.setVeiculo(v2);
		r2.setDataExecucao("18/10/2018");
		List<Rota> rotas = new ArrayList<>();
		rotas.add(r1);
		rotas.add(r2);
		
		dao.inserir(rotas);
	}	

	@Test
	public void pesquisarTest() {
		RotaDBDao dao = new RotaDBDao();
		dao.pesquisar("23455", null );
	}
	
	@Test
	public void removerTest() {
		RotaDBDao dao = new RotaDBDao();
		Rota rota = new Rota();
		rota.setDataExecucao("2018-11-20");
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ghu-7676");
		
		rota.setVeiculo(veiculo);
		
		dao.remover(rota);
	}

	@Test
	public void rotaDetalhadaTest() {
		RotaDBDao dao = new RotaDBDao();
	
		dao.rotaDetalhada("2018-11-20", "dsu-2837");
	}

	@Test
	public void caminhoTest(){
		Properties properties = new Properties();
		FileInputStream resource;
		try {
			resource = new FileInputStream("./arquivos/config.properties");
			properties.load(resource);
		} catch (IOException e1) {
			e1.printStackTrace();
		}

		String persistencia = properties.getProperty("config");
		String path = properties.getProperty("caminho");
	}
}
