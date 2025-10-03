package LOGICA;

import java.sql.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DATOS.DB;
import ENTIDADES.Cliente;
import ENTIDADES.Familia;
import INTERFACES.ICliente;

public class LCliente implements ICliente {
	
	private DB db;
	private Connection cn;
	private PreparedStatement ps;
	private ResultSet rs;

	@Override
	public void guardar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		db= new DB();
		cn=db.conectar();
		String sql= "insert into cliente (nombres, apellidos, dni, edad) values (?,?,?,?)";
		ps=cn.prepareStatement(sql);
		ps.setString(1, cliente.getNombres());
		ps.setString(2, cliente.getApellidos());
		ps.setString(3, cliente.getDni());
		ps.setInt(4, cliente.getEdad());
		
		

		ps.execute();
		ps.close();
	}

	@Override
	public void modificar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borrar(Cliente cliente) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Cliente> cargar() throws SQLException {
		// TODO Auto-generated method stub
		db= new DB();
		cn=db.conectar();
		String sql= "select * from cliente";
		ps=cn.prepareStatement(sql);
		ArrayList<Cliente> clientes=new ArrayList<Cliente>();
		rs= ps.executeQuery();
		while (rs.next()) {
			clientes.add(new Cliente(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),rs.getInt(5)));
		}
		cn.close();
		return clientes;
	
	}

	@Override
	public Familia cargar(int idcliente) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

}
