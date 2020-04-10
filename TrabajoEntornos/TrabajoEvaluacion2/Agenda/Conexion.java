package Agenda;

import java.sql.*;

/**
 * Clase de conexión, la cual es la que se conecta a la Base de Datos
 * @author Chema
 *
 */

public class Conexion {
	
	/**
	 * Atributos
	 */
	
	private boolean isDBConected;
	private static Connection con;
	
	
	public Conexion() {
		super();
		
	}
	
	public final Connection getCon() {
		return con;
	}
	
	/**
	 * Metodo que hace la conexion a la Base de datos
	 * @return . Devuelve un boolean que nos devolvera "true" si la base de datos se ha conectado, y false si no se ha conectado.
	 */
	
	public boolean conexion() {
	try
	{
	Class.forName("com.mysql.cj.jdbc.Driver");
	con = DriverManager.getConnection("jdbc:mysql://localhost:3306/testDB?serverTimezone=UTC","root","Chema-dam10");
	return isDBConected = true;
	}
	catch(Exception e)
	{
	
	System.out.println("Error en conexion con la base de datos");
	System.out.println(e);
	return isDBConected = false;
	}
	}
	
}
