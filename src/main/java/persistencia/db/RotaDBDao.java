package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidade.Pacote;
import entidade.Rota;
import entidade.Veiculo;
import persistencia.idao.IRotaDao;

public class RotaDBDao implements IRotaDao {

	@Override
	public Map<String, List<Rota>> listar() {
		Connection con = Conexao.getConnection();
		String sql = "select * from rota order by data, placa_veiculo";
		PreparedStatement statement;
		ResultSet rs = null;
		Map<String, List<Rota>> rotas = new HashMap<>();
		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();

			Veiculo veiculo = null;
			Pacote pacote = null;
			List<Pacote> pacotes = new ArrayList<>();
			List<Rota> listaRota= new ArrayList<>();
			String dataExec;
			
			while (rs.next()) {
				pacote = new Pacote();
				if (veiculo == null || veiculo.getPlaca() != rs.getString("placa_veiculo")) {
					if(veiculo != null) {
						veiculo.setListaDePacote(pacotes);
						pacotes.clear();
						Rota rota = new Rota();
						rota.setDataExecucao(dataExec);
						rota.setVeiculo(veiculo);
						if(dataExec != "") {// Proxima data
							rotas.put(dataExec, listaRota);
							listaRota.clear();
						}
					}
					veiculo = new Veiculo();
					veiculo.setAno(ano);
					veiculo.setMarca(marca);
					veiculo.setModelo(modelo);
					veiculo.setPlaca(placa);
					veiculo.setTipo(tipo);
				}
				pacote.setCodLocalizador(codLocalizador);
				pacote.setDataInsercao(dataInsercao);
				pacote.setEndDestino(endDestino);
				pacote.setEndRemetente(endRemetente);
				pacote.setEntrega(entrega);
				pacote.setNomeDestino(nomeDestino);
				pacote.setNomeRemetente(nomeRemetente);
				pacote.setPeso(peso);
				pacote.setRoteirizado(roteirizado);
				pacotes.add(pacote);
				dataExec = "";

			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return rotas;
	}

	@Override
	public void atualizar(Rota veiculo, String id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remover(Rota veiculo) {
		// TODO Auto-generated method stub

	}


	@Override
	public void inserir(List<Rota> rotas) {
		Connection con = Conexao.getConnection();
		String sql = "Insert into rota(localizador_pacote, placa_veiculo) values(?,?)";
		PreparedStatement statement;
		for (Rota rota : rotas) {
			try {
				statement = con.prepareStatement(sql);
				statement.setString(1, rota.getVeiculo().getPlaca());
				for (Pacote pacote : rota.getVeiculo().getListaDePacote()) {
					statement.setString(2, pacote.getCodLocalizador());
					statement.execute();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				System.err.println(e.getMessage());
			}
		}

	}

}
