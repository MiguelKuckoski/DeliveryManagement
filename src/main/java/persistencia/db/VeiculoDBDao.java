package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import entidade.Motorista;
import entidade.Veiculo;
import persistencia.idao.IVeiculoDao;

public class VeiculoDBDao implements IVeiculoDao{

	@Override
	public boolean inserir(String placa, Veiculo veiculo) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i =0;
		String sql ="";
		
		try {
			con.prepareStatement(sql);
			statement.setString(1, "");
			
			 i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0? true:false;
	}

	@Override
	public Map<String, Veiculo> listar() {
		Connection con = Conexao.getConnection();
		String sql ="";
		ResultSet rs = null;
		PreparedStatement statement = null;
		
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, "");
			
			 rs = statement.executeQuery();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public boolean atualizar(String placa, Veiculo veiculo) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i =0;
		String sql ="";
		
		try {
			con.prepareStatement(sql);
			statement.setString(1, "");
			
			 i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0? true:false;
	}

	@Override
	public boolean remover(String placa) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i =0;
		String sql ="";
		
		try {
			con.prepareStatement(sql);
			statement.setString(1, "");
			
			 i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0? true:false;
	}

	@Override
	public boolean vincularMotorista(String placa, Motorista motorista) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i =0;
		String sql ="";
		
		try {
			con.prepareStatement(sql);
			statement.setString(1, "");
			
			 i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0? true:false;
		
	}

	@Override
	public boolean desvincularMotorista(String placa, Motorista motorista) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		int i =0;
		String sql ="";
		
		try {
			con.prepareStatement(sql);
			statement.setString(1, "");
			
			 i = statement.executeUpdate();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
			e.printStackTrace();
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return i > 0? true:false;
	}

}
