package persistencia;

import persistencia.db.MotoristaDBDao;
import persistencia.db.PacoteDBDao;
import persistencia.db.VeiculoDBDao;
import persistencia.file.MotoristaFileDAO;
import persistencia.file.PacoteFileDAO;
import persistencia.file.VeiculoFileDAO;
import persistencia.idao.IMotoristaDao;
import persistencia.idao.IPacoteDao;
import persistencia.idao.IRotaDao;
import persistencia.idao.IVeiculoDao;

public class DaoFactory {

	public static IPacoteDao getPacoteDAO(String type) {

		if (type.equalsIgnoreCase("postgre")) {
			return new PacoteDBDao();
		} else {
			return new PacoteFileDAO();
		}
	}
	
	public static IMotoristaDao getMotoristaDAO(String type) {

		if (type.equalsIgnoreCase("postgre")) {
			return new MotoristaDBDao();
		} else {
			return new MotoristaFileDAO();
		}
	}
	
	public static IVeiculoDao getVeiculoDAO(String type) {

		if (type.equalsIgnoreCase("postgre")) {
			return new VeiculoDBDao();
		} else {
			return new VeiculoFileDAO();
		}
	}

	public static IRotaDao getRotaDao(String type) {
		if (type.equalsIgnoreCase("postgre")) {
//			return new RotaDBDao();
		} else {
//			return new VeiculoFileDAO();
		}
		return null;
	}
	
	
}
