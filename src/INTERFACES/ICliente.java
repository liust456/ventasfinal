package INTERFACES;


import java.sql.SQLException;
import java.util.ArrayList;

import ENTIDADES.Cliente;
import ENTIDADES.Familia;

public interface ICliente {
	void guardar(Cliente cliente) throws SQLException;
	void modificar(Cliente cliente) throws SQLException;
	void borrar(Cliente cliente) throws SQLException;
	
	ArrayList<Cliente> cargar() throws SQLException;
	Familia cargar(int idcliente)throws SQLException;
}