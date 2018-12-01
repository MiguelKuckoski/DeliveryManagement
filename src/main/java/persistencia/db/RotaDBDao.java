package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
	public Map<String, List<Rota>> pesquisar(String cnhMotorista, String data) {
		Connection con = Conexao.getConnection();
		String sql = "select distinct data, placa_veiculo, marca, modelo, placa, motorista, tipo, ano, nome, cnh_tipo, endereco, veiculo, data_nasc, cnh_num from rota r "
				+ "join veiculo v on r.placa_veiculo = v.placa " + "join motorista m on m.cnh_num = v.motorista ";

		if (cnhMotorista != null && data != null) {
			sql += "where data = '" + data + "' and motorista = '" + cnhMotorista + "'";
		} else if (cnhMotorista != null) {
			sql += "where motorista = '" + cnhMotorista + "'";
		} else if(data != null){
			sql += "where data = '" + data + "'";
		}
		sql += " order by data, placa_veiculo";

		ResultSet rs = null;
		Map<String, List<Rota>> rotas = new HashMap<>();
		Statement statement = null;
		try {
			statement = con.createStatement();
			rs = statement.executeQuery(sql);
			List<Rota> listaRota = new ArrayList<>();
			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				Motorista motorista = new Motorista();
				Rota rota = new Rota();

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
				String dataExec = rs.getString("data");

				rota.setVeiculo(veiculo);
				rota.setDataExecucao(dataExec);
				listaRota.add(rota);
			}
			listaRota.parallelStream().forEach(rota1 -> {
				if (rotas.containsKey(rota1.getDataExecucao())) {
					rotas.get(rota1.getDataExecucao()).add(rota1);
				} else {
					List<Rota> listaRota1 = new ArrayList<>();
					listaRota1.add(rota1);
					rotas.put(rota1.getDataExecucao(), listaRota1);
				}
			});

		} catch (SQLException e) {
			e.printStackTrace();
			System.err.println(e.getMessage());
		} finally {
			try {
				statement.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
			}
		}
		return rotas;
	}

	@Override
	public void remover(Rota rota) {
		Connection con = Conexao.getConnection();
		String sql = "delete from rota where data= ? and placa_veiculo = ?";
		PreparedStatement statement = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = format.parse(rota.getDataExecucao());
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			statement = con.prepareStatement(sql);
			statement.setDate(1, sqlDate);
			statement.setString(2, rota.getVeiculo().getPlaca());
			statement.execute();
		} catch (SQLException | ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException ex) {
			}
		}
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

	@Override
	public Rota rotaDetalhada(String data, String veiculoPlaca) {
		Connection con = Conexao.getConnection();
		String sql = "select * from rota r " + "join veiculo v on r.placa_veiculo = v.placa "
				+ "join motorista m on m.cnh_num = v.motorista "
				+ "join pacote p on r.localizador_pacote = p.cod_localizador "
				+ "where r.data = ? and r.placa_veiculo = ?";

		PreparedStatement statement = null;
		ResultSet rs = null;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Rota rota = null;

		try {
			Date date = format.parse(data);
			java.sql.Date sqlDate = new java.sql.Date(date.getTime());
			statement = con.prepareStatement(sql);
			statement.setDate(1, sqlDate);
			statement.setString(2, veiculoPlaca);
			rs = statement.executeQuery();
			Veiculo veiculo = null;
			List<Pacote> pacotes = new ArrayList<>();
			while (rs.next()) {

				Pacote pacote = new Pacote();
				pacote.setCodLocalizador(rs.getString("cod_localizador"));
				pacote.setNomeRemetente(rs.getString("nome_remetente"));
				pacote.setEndRemetente(rs.getString("end_remetente"));
				pacote.setNomeDestino(rs.getString("nome_destinatario"));
				pacote.setEndDestino(rs.getString("end_destinatario"));
				pacote.setPeso(rs.getDouble("peso"));
				pacote.setDataInsercao(rs.getDate("data_insercao"));
				pacote.setEntrega(rs.getBoolean("entregue"));
				pacote.setRoteirizado(rs.getBoolean("roteirizado"));
				pacotes.add(pacote);

				if (veiculo == null) {
					rota = new Rota();
					rota.setDataExecucao(data);
					veiculo = new Veiculo();
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setAno(rs.getInt("ano"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setTipo(rs.getInt("tipo"));
					Motorista motorista = new Motorista();
					motorista.setNome(rs.getString("nome"));
					motorista.setNascimento(rs.getString("data_nasc"));
					motorista.setCnhNum(rs.getString("cnh_num"));
					motorista.setCnhTipo(rs.getString("cnh_tipo"));
					motorista.setEndereco(rs.getString("endereco"));
					motorista.setVinculadoCarro(rs.getBoolean("veiculo"));
					veiculo.setMotorista(motorista);
				}
			}
			if (rota != null) {
				veiculo.setListaDePacote(pacotes);
				rota.setVeiculo(veiculo);
			}
		} catch (SQLException | ParseException e) {
			System.err.println(e.getMessage());
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException ex) {
			}
		}

		return rota;
	}

}
