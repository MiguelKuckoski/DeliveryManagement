package persistencia.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import entidade.Pacote;
import persistencia.idao.IPacoteDao;

public class PacoteDBDao implements IPacoteDao{

	@Override
	public boolean inserir(Pacote pacote) {
		Connection con = Conexao.getConnection();
		boolean inserido = false;
		PreparedStatement statement = null;
		
		String sql = "INSERT INTO pacote(cod_localizador, nome_remetente, end_remetente, nome_destinatario, end_destinatario, peso, entregue, roteirizado)"
				+ " values(?,?,?,?,?,?,?,?)";
		
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, pacote.getCodLocalizador());
			statement.setString(2, pacote.getNomeRemetente());
			statement.setString(3, pacote.getEndRemetente());
			statement.setString(4, pacote.getNomeDestino());
			statement.setString(5, pacote.getEndDestino());
			statement.setDouble(6, pacote.getPeso());
			statement.setBoolean(7, pacote.isEntrega());
			statement.setBoolean(8, pacote.isRoteirizado());
			
			inserido = statement.execute();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return inserido;
	}

	@Override
	public Map<String, Pacote> listar() {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		Map<String, Pacote> pacotes = new HashMap<>();
		
		String sql = "Select * from pacote";
		try {
			statement = con.prepareStatement(sql);
			rs = statement.executeQuery();
			
			while(rs.next()) {
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
				
				pacotes.put(pacote.getCodLocalizador(), pacote);
			}
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				rs.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return pacotes;
	}

	@Override
	public boolean atualizar(Pacote pacote, String codRastreio) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		boolean atualizado = false;

		String sql = "update pacote set cod_localizador=?, nome_remetente = ?, end_remetente=?, nome_destinatario=?, end_destinatario=?, peso =?, entregue=?,"
				+ "roteirizado = ? "
				+ " where cod_localizador = ?";
		
		try {
			statement = con.prepareStatement(sql);
			
			statement.setString(1, pacote.getCodLocalizador());
			statement.setString(2, pacote.getNomeRemetente());
			statement.setString(3, pacote.getEndRemetente());
			statement.setString(4, pacote.getNomeDestino());
			statement.setString(5, pacote.getEndDestino());
			statement.setDouble(6, pacote.getPeso());
			statement.setBoolean(7, pacote.isEntrega());
			statement.setBoolean(8, pacote.isRoteirizado());
			statement.setString(9, codRastreio);
			
			atualizado = statement.execute();
			
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	
		return atualizado;
	}

	@Override
	public boolean remover(Pacote pacote) {
		Connection con = Conexao.getConnection();
		PreparedStatement statement = null;
		boolean removido = false;
		String sql = "delete from pacote where cod_localizador = ? ";
		
		try {
			statement = con.prepareStatement(sql);
			statement.setString(1, pacote.getCodLocalizador());
			removido = statement.execute();
		} catch (SQLException e) {
			System.err.println(e.getMessage());
		}finally {
			try {
				statement.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return removido;
	}
	
}
