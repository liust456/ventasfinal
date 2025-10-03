package DATOS;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DB {
    public Connection conectar() throws SQLException {
		String url="jdbc:postgresql://localhost/ventasfinal";
		String user="postgres";
		String password="1234";
        Connection cn = DriverManager.getConnection(url, user, password);
		return cn;
	}
}