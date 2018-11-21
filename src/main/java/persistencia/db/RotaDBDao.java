package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import entidade.Motorista;
import entidade.Pacote;
import entidade.Rota;
import entidade.Veiculo;
import persistencia.idao.IRotaDao;

public class RotaDBDao implements IRotaDao {

	@Override
	public Map<String, List<Rota>> listar() {
		Connection con = Conexao.getConnection();
		String sql = "select * from rota join pacote on cod_localizador = localizador_pacote "
				+ "join veiculo on placa_veiculo = placa j"
				+ "oin motorista on motorista = cnh_num order by data, placa_veiculo";
		PreparedStatement statement;
		ResultSet rs = null;
		Map<String, List<Rota>> rotas = new HashMap<>();
		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();

			Veiculo veiculo = null;
			Pacote pacote = null;
			List<Pacote> pacotes = new ArrayList<>();
			List<Rota> listaRota = new ArrayList<>();
			String dataExec = null;
			Rota rota = new Rota();

			while (rs.next()) {
				pacote = new Pacote();
				
				if (veiculo == null) {
					veiculo = setVeiculo(rs);
				}
				pacotes = new ArrayList<>();
				pacote.setCodLocalizador(rs.getString("cod_localizador"));
				pacote.setNomeRemetente(rs.getString("nome_remetente"));
				pacote.setEndRemetente(rs.getString("end_remetente"));
				pacote.setNomeDestino(rs.getString("nome_destinatario"));
				pacote.setEndDestino(rs.getString("end_destinatario"));
				pacote.setPeso(rs.getDouble("peso"));
				pacote.setDataInsercao(rs.getDate("data_insercao"));
				pacote.setEntrega(rs.getBoolean("entregue"));
				pacote.setRoteirizado(rs.getBoolean("roteirizado"));
				dataExec = rs.getString("data");
				
				if(veiculo.getPlaca().equals(rs.getString("placa")) && dataExec.equals(rs.getString("data"))) {
					pacotes.add(pacote);
					veiculo.setListaDePacote(pacotes);
					rota.setDataExecucao(dataExec);
					rota.setVeiculo(veiculo);
					if(!listaRota.contains(rota)) {
						listaRota.add(rota);
					}
				}else {
					rota = new Rota();
					veiculo = setVeiculo(rs);
					pacotes.clear();
					pacotes.add(pacote);
					veiculo.setListaDePacote(pacotes);
					rota.setDataExecucao(dataExec);
					rota.setVeiculo(veiculo);
					listaRota.add(rota);
				}
			}
			
			listaRota.parallelStream().forEach(rota1 -> {
				if (rotas.containsKey(rota1.getDataExecucao())) {
					rotas.get(rota1.getDataExecucao()).add(rota1);
				}else {
					List<Rota> listaRota1 = new ArrayList<>();
					listaRota1.add(rota1);
					rotas.put(rota1.getDataExecucao(), listaRota1);
				}
			});
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return rotas;
	}

	private Veiculo setVeiculo(ResultSet rs) {
		Veiculo veiculo = new Veiculo();
		Motorista motorista = new Motorista();
		try {
			motorista.setNome(rs.getString("nome"));
			motorista.setNascimento(rs.getString("data_nasc"));
			motorista.setCnhNum(rs.getString("cnh_num"));
			motorista.setCnhTipo(rs.getString("cnh_tipo"));
			motorista.setEndereco(rs.getString("endereco"));
			motorista.setVinculadoCarro(rs.getBoolean("veiculo"));
			veiculo.setPlaca(rs.getString("placa"));
			veiculo.setAno(rs.getInt("ano"));
			veiculo.setMarca(rs.getString("marca"));
			veiculo.setModelo(rs.getString("modelo"));
			veiculo.setTipo(rs.getInt("tipo"));
			veiculo.setMotorista(motorista);
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
		return veiculo;

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
		try {
			statement = con.prepareStatement(sql);
			for (Rota rota : rotas) {
				statement.setString(2, rota.getVeiculo().getPlaca());
				for (Pacote pacote : rota.getVeiculo().getListaDePacote()) {
					statement.setString(1, pacote.getCodLocalizador());
					statement.execute();
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		}
	}
}
