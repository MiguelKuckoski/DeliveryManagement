package persistencia;

import persistencia.db.PacoteDBDao;
import persistencia.file.PacoteFileDAO;
import persistencia.idao.IPacoteDao;

public class DaoFactory {
	
    public static IPacoteDao getPacoteDAO(String type){ 
        
    	if (type.equalsIgnoreCase("postgre")){
            return new PacoteDBDao();
        }else{
            return new PacoteFileDAO();
        }
    }
}
