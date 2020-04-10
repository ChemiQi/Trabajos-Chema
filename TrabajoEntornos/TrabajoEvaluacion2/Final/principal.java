package Final;

import Agenda.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) {
		
		Connection con;		
		Conexion c1 = new Conexion();
		c1.conexion();
		con = c1.getCon();
		ListadeContacto lc = new ListadeContacto( cogerContactos(con));
		
		int menu = 0;
		Scanner teclado = new Scanner(System.in);
		
		int menu2 = 0;
		
		if (lc.getConexion().conexion() == true) {
			do {
				System.out.println("---------------------MENU------------------");
				System.out.println("--------------------AGENDA------------------)");
				System.out.println("");
				System.out.println("1 > Mostrar Contactos");
				System.out.println("2 > Buscar contacto");
				System.out.println("3 > Salir");
				menu = teclado.nextInt();
				teclado.nextLine();
				
				switch (menu) {
				case 1:
					lc.mostrarContactos();
					System.out.println("...");
					System.out.println("Pulse una tecla para continuar");
					System.out.println("");
					teclado.nextLine();
					break;
				case 2:
					System.out.println("¿Qué metodo deseas usar para buscar el usuario?");
					System.out.println("1 --> Telefono");
					System.out.println("2 --> Correo electronico");
					menu2 = teclado.nextInt();
					teclado.nextLine();
					
					if (menu2 == 1) {
						System.out.println("Escriba el numero de telefono");
						int telefono = teclado.nextInt();
						teclado.nextLine();
						lc.buscarPor(telefono);
						System.out.println("...");
						System.out.println("Pulse una tecla para continuar");
						System.out.println("");
						teclado.nextLine();
					}
					else if (menu2 == 2) {
						System.out.println("Escriba el correo electronico");
						String correo = teclado.nextLine();
						lc.buscarPor(correo);
						System.out.println("...");
						System.out.println("Pulse una tecla para continuar");
						System.out.println("");
						teclado.nextLine();
					}
				case 3:
					System.out.println("Gracias y vuelva pronto");
					break;
				default:
				}
			}while(menu !=3);
		}
		
		
	}
	
	
	
	
	//METODOS -----------------------------------------------------------------------------
	
	
	private static ArrayList<Contactos> cogerContactos(Connection con) {
		ArrayList<Contactos> contactos = new ArrayList<Contactos>();
	
		try {
			Statement stmt=con.createStatement();
			int i =numeroDeContactos(stmt);
			for(int y= 1; y <= i;y++ ) {
				
				String nombre = seleccionarNombre(stmt,y);
				String apellido1 = seleccionarApellido1(stmt,y);
				String apellido2 = seleccionarApellido2(stmt,y);
				String direccion = seleccionarDireccion(stmt,y);
				String email = seleccionarEmail(stmt,y);
				int telefono = seleccionarTelefono(stmt,y);
				
				Contactos cy = new Contactos (y,nombre,apellido1,apellido2,direccion,email,telefono);
				contactos.add(cy);
				
			} 
		} catch (SQLException e) {	
			e.printStackTrace();
		}
		
		return contactos;
}

	private static int numeroDeContactos(Statement stmt) {
		ResultSet rs;
		String a ;
		int x;
		try {
			
			rs = stmt.executeQuery("SELECT  COUNT(id) FROM agenda.contactos;");
			if(rs.next())
			{
				  a = rs.getString(1);	
				  return x = Integer.parseInt(a);
			}else
			{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}


	private static String seleccionarNombre(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		try {
			rs = stmt.executeQuery("select nombre from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				return  a = rs.getString(1);	
			}else
			{
				return null;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static String seleccionarApellido1(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		try {
			rs = stmt.executeQuery("select apellido1 from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				return  a = rs.getString(1);	
			}else
			{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String seleccionarApellido2(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		try {
			rs = stmt.executeQuery("select apellido2 from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				return  a = rs.getString(1);	
			}else
			{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String seleccionarDireccion(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		try {
			rs = stmt.executeQuery("select direccion from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				return  a = rs.getString(1);	
			}else
			{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static String seleccionarEmail(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		try {
			rs = stmt.executeQuery("select email from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				return  a = rs.getString(1);	
			}else
			{
				return null;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static int seleccionarTelefono(Statement stmt, int i) {
		ResultSet rs;
		String a ;
		int x;
		try {
			rs = stmt.executeQuery("select telefono from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				  a = rs.getString(1);	
				  return x = Integer.parseInt(a);
			}else
			{
				return 0;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	
	
	

}
