package INTERFACES;

import java.sql.SQLException;
import java.util.ArrayList;
import ENTIDADES.Familia;

public interface IFamilia {
	void guardar(Familia familia) throws SQLException;
	void modificar(Familia familia) throws SQLException;
	void borrar(Familia familia) throws SQLException;
	
	ArrayList<Familia> cargar() throws SQLException;
	Familia cargar(int idFamilia)throws SQLException;
}