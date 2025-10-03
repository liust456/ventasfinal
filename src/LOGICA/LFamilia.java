package LOGICA;

import java.sql.*;
import java.util.ArrayList;

import DATOS.DB;
import ENTIDADES.Familia;
import INTERFACES.IFamilia;

public class LFamilia implements IFamilia{
	private DB db;
	private Connection cn;
	private PreparedStatement ps;
	private ResultSet rs;
	
	@Override
	public void guardar(Familia familia) throws SQLException {
		db= new DB();
		cn=db.conectar();
		String sql= "insert into familia(nombre, descripcion) values (?,?)";
		ps=cn.prepareStatement(sql);
		ps.setString(1, familia.getNombre());
		ps.setString(2, familia.getDescripcion());
		ps.execute();
		ps.close();
		
	}
	@Override
	public void modificar(Familia familia) throws SQLException {
		db= new DB();
		cn=db.conectar();
		String sql= "update familia set nommbre=?, descripcion=? where idfamilia=?";
		ps=cn.prepareStatement(sql);
		ps.setString(1, familia.getNombre());
		ps.setString(2, familia.getDescripcion());
		ps.setInt(3, familia.getIdfamilia());
		ps.execute();
		ps.close();
		
	}
	@Override
	public void borrar(Familia familia) throws SQLException {
		db= new DB();
		cn=db.conectar();
		String sql= "delete from familia where idfamilia=?";		
		ps.setInt(1, familia.getIdfamilia());
		ps.execute();
		ps.close();
		
	}
	@Override
	public ArrayList<Familia> cargar() throws SQLException {
		db= new DB();
		cn=db.conectar();
		String sql= "select * from familia";
		ps=cn.prepareStatement(sql);
		ArrayList<Familia> familias=new ArrayList<Familia>();
		rs= ps.executeQuery();
		while (rs.next()) {
			familias.add(new Familia(rs.getInt(1), rs.getString(2), rs.getString(3)));
		}
		cn.close();
		return familias;
	}
	@Override
	public Familia cargar(int idFamilia) throws SQLException {
		db= new DB();
		cn=db.conectar();
		String sql= "select * from familia where idfamilia=?";
		ps=cn.prepareStatement(sql);
		ps=setInt(1, idFamilia);
		rs=ps.executeQuery();
		Familia familia=new Familia();
		if (rs.next()) {
			familia=new Familia(rs.getInt(1), rs.getString(2), rs.getString(3));
		}
		
		cn.close();
		return familia;
	}
	private PreparedStatement setInt(int i, int idFamilia) {
		// TODO Auto-generated method stub
		return null;
	}	
}
