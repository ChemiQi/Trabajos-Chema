package Final;

import Agenda.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class principal {

	public static void main(String[] args) {
		
				
		Conexion c1 = new Conexion();
		c1.conexion();
		
		ArrayList<Contactos> con = cogerContactos(c1.getCon());
		Statement stmt = conStat(c1.getCon());
		ListadeContacto lc = new ListadeContacto(con);
		
		
		int menu = 0;
		Scanner teclado = new Scanner(System.in);
		String busqueda;
		int menu2 = 0;
		
		if (lc.getConexion().conexion() == true) {
			do {
				System.out.println("---------------------MENU------------------");
				System.out.println("--------------------AGENDA------------------)");
				System.out.println("");
				System.out.println("1 > Mostrar Contactos");
				System.out.println("2 > Buscar contacto");
				System.out.println("3 > Crear contacto");
				System.out.println("4 > Salir");
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
				case 4:
					System.out.println("Gracias y vuelva pronto");
					break;
				case 3:
					int menu3 = 0;
					do {
						System.out.println("Dime los datos del nuevo contacto");
						System.out.println("Nombre");
						String nombre = teclado.nextLine();
						System.out.println("Primer apellido");
						String apellido1 = teclado.nextLine();
						System.out.println("Segundo apelldio");
						String apellido2 = teclado.nextLine();
						System.out.println("Calle");
						String calle = teclado.nextLine();
						System.out.println("Correo electronico");
						String email = teclado.nextLine();
						System.out.println("Telefono");
						int tel = teclado.nextInt();
						teclado.nextLine();
						System.out.println("Estos son los datos??");
						Contactos c2 = new Contactos (0,nombre,apellido1,apellido2,calle,email,tel);
						c2.mostrarContacto();
						System.out.println("-------------------------------------------------------\nSi -->1 \nNo -->2");
						 menu3 = teclado.nextInt();
						 teclado.nextLine();
						if(menu3 ==1)
						{
							con.add(c2);
							añadridContactoBBDD(c2,stmt);
							System.out.println("Contacto creado");
						}
						if(menu3 == 2) {
							System.out.println("Añada otra vez los datos");
						}
					}while(menu3 !=1);
				default:
				}
			}while(menu !=4);
		}
		
	}
	
	
	
	
	




	//METODOS -----------------------------------------------------------------------------
	private static Statement conStat(Connection con) {
		try {
			return con.createStatement();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return null;
		
	}
	
	private static ArrayList<Contactos> cogerContactos(Connection con) {
		ArrayList<Contactos> contactos = new ArrayList<Contactos>();
	
		try {
			Statement stmt=con.createStatement();
			int i =numeroDeContactos(stmt);
			for(int y= 1; y <= i;y++ ) {
				
				contactos.add(cogerContacto(y,stmt));
				
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
	
	private static Contactos cogerContacto(int i, Statement stmt) {
		ResultSet rs;
		try {
			rs = stmt.executeQuery("select * from agenda.contactos where id ='" + i + "'");
			if(rs.next())
			{
				
				int telefono = Integer.parseInt(rs.getString(7));
				return new Contactos(i,rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),telefono);
				
			}else
			{
				return null;
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	private static void añadridContactoBBDD(Contactos c2, Statement stmt) {
		
		try {
			System.out.println("Has llegado aqui");
			stmt.executeUpdate("insert into agenda.contactos (nombre,apellido1,apellido2,direccion,email,telefono) values ('"+c2.getNombre()+"','" + c2.getApellido1() + "','" + c2.getApellido2() + "','" + c2.getDireccion()
			+"','" + c2.getEmail() +"','"+ String.valueOf(c2.getTelefono()) + "')");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}
	
	
	
	
	

}
