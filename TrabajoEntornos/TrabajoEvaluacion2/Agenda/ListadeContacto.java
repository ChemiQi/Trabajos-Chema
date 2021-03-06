package Agenda;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;



/**
 * Tercera clase la cual necesitaremos un Arraylist de contactos, donde se a�adiran los contactos de la base de datos, y una conexion a esta.
 * @author Chema
 *
 */

public class ListadeContacto {
	
	/**
	 * Atributos
	 */
	
	private ArrayList<Contactos> contactos;
	private Conexion conexion ;
	
	/**
	 * Constructores
	 */
	
	public ListadeContacto(ArrayList<Contactos> contactos) {
		super();
		if (contactos == null) {
		this.contactos = new ArrayList<Contactos>();
		}else{
		this.contactos = contactos;
		}
		this.conexion = new Conexion();
		if (conexion.conexion() == false)
			{
				
			}else {
				System.out.println("Conectado satisfactoriamente \n");
			}
	}
	
	/**
	 * Manera de obtener el estado de la conexion
	 * @return boolean con el estado de la conexion
	 */
	public final Conexion getConexion() {
		return conexion;
	}
	
	
	/**
	 * Metodo para mostrar contactos del arraylist, usando el metodo propio de "Contactos"
	 */
	public void mostrarContactos() {
		for(Contactos c : this.contactos) {
			c.mostrarContacto();
			System.out.println("-------------------------------------------");
		}
	}
	/**
	 * Busqueda de contacto por numero de telefono
	 * @param telefono . Un numero telefono que a�adimos nosotros
	 */
	public void buscarPor(int telefono){
		int x = 0;
		System.out.println("Hemos encontrado los siguientes contactos por ese numero de telefono: \n");
		for(Contactos c : this.contactos)
		{
			if(telefono == c.getTelefono()) {
				c.mostrarContacto();
				x++;
			}
		}
		if (x == 0) {
			System.out.println("No se han encontrado contactos");
		}
	}
	/**
	 * Metodo para buscar un contacto por el atributo email
	 * @param email . Correo electronico que a�adimos para la busqueda
	 */
	public void buscarPor(String email){
		int x = 0;
		System.out.println("Hemos encontrado los siguientes contactos por ese email: \n");
		for(Contactos c : this.contactos)
		{
			if(email.equalsIgnoreCase(c.getEmail())) {
				c.mostrarContacto();
				x++;
			}
		}
		if (x == 0) {
			System.out.println("No se han encontrado contactos");
		}
	}
	
	/**
	 * Nos devuelve un numero de contactos que tenemos en la base de datos, para crear el arraylist
	 * @param stmt -> La conexion que tenemos
	 * @return -> Nos devuelve el numero de contactos que tenemos en la base de datos
	 */
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
	
	/**
	 * Metodo para borrar el contacto de la arraylist usando un itinerador
	 * @param telefono le pasamos el numero de telefono del contacto que queremos borrar
	 */
	public void borrarDeArray(int telefono) {
		Iterator<Contactos> it = this.contactos.iterator();
		while (it.hasNext())
		{
			Contactos a = it.next();
			if(telefono == a.getTelefono()) {
				it.remove();
			}
		}
		
	}
	
	
}
