package Agenda;

import java.sql.*;



public class Conexion {
	
	private boolean isDBConected;
	private static Connection con;
	
	
	public Conexion() {
		super();
		
	}
	
	public final Connection getCon() {
		return con;
	}
	
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

	
	public static void main(String[] args) {
		
		Conexion c1 = new Conexion();
		c1.conexion();
		
	}



	
	
	
}
