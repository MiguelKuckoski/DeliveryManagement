package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.idao.IVeiculoDao;

public class VeiculoDBDao implements IVeiculoDao {

	@Override
	public boolean inserir(String placa, Veiculo veiculo) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		String sql = "insert into veiculo(marca, modelo, placa, ano, tipo) values(?,?,?,?,?)";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, veiculo.getMarca());
			statement.setString(2, veiculo.getModelo());
			statement.setString(3, veiculo.getPlaca());
			statement.setInt(4, veiculo.getAno());
			statement.setInt(5, veiculo.getTipo());

			i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0 ? true : false;
	}

	@Override
	public Map<String, Veiculo> listar() {
		Connection con = Conexao.getConnection();
		String sql = "select * from veiculo";
		ResultSet rs = null;
		PreparedStatement statement = null;
		Map<String, Veiculo> veiculos = new HashMap<>();

		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();

			while (rs.next()) {
				Veiculo veiculo = new Veiculo();
				veiculo.setPlaca(rs.getString("placa"));
				veiculo.setAno(rs.getInt("ano"));
				veiculo.setMarca(rs.getString("marca"));
				veiculo.setModelo(rs.getString("modelo"));
				veiculo.setTipo(rs.getInt("tipo"));
				int motoristaId = rs.getInt("motorista");
				if (motoristaId > 0) {
					veiculo.setMotorista(getMotorista(motoristaId));

				}
				veiculos.put(veiculo.getPlaca(), veiculo);
			}

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return veiculos;
	}

	private Motorista getMotorista(int idMotorista) {
		Connection con = Conexao.getConnection();
		String sql = "select * from motorista where cnh_num= ?";
		ResultSet rs = null;
		PreparedStatement statement = null;
		Motorista motorista = new Motorista();

		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, idMotorista);
			rs = statement.executeQuery();

			while (rs.next()) {
				motorista.setNome(rs.getString("nome"));
				motorista.setNascimento(rs.getString("data_nasc"));
				motorista.setCnhNum(rs.getString("cnh_num"));
				motorista.setCnhTipo(rs.getString("cnh_tipo"));
				motorista.setEndereco(rs.getString("endereco"));
				motorista.setVinculadoCarro(rs.getBoolean("veiculo"));
			}
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return motorista;
	}

	@Override
	public boolean atualizar(String placa, Veiculo veiculo) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		String sql = "update veiculo set marca=?, modelo =?, tipo =?, ano =? where placa = ?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, veiculo.getMarca());
			statement.setString(2, veiculo.getModelo());
			statement.setInt(3, veiculo.getTipo());
			statement.setInt(4, veiculo.getAno());
			statement.setString(5, placa);
			i = statement.executeUpdate();

		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0 ? true : false;
	}

	@Override
	public boolean remover(String placa) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i = 0;
		String sql = "delete from veiculo where placa =? ";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, placa);
			i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0 ? true : false;
	}

	@Override
	public void vincularMotorista(String placa, Motorista motorista) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		String sql = "update veiculo set motorista=? where placa=?";

		try {
			statement = con.prepareStatement(sql);
			statement.setInt(1, Integer.parseInt(motorista.getCnhNum()));
			statement.setString(2, placa);
			statement.execute();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	@Override
	public void desvincularMotorista(String placa, Motorista motorista) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		String sql = "update veiculo set motorista = null where placa=?";

		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, placa);
			statement.execute();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		} finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
