package Agenda;

import java.util.ArrayList;

public class ListadeContacto {
	
	private ArrayList<Contactos> contactos;
	private Conexion conexion ;
	
	//CONSTRUCTORES
	
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
	//GET AND SETTER
	
	public final ArrayList<Contactos> getContactos() {
		return contactos;
	}
	public final void setContactos(ArrayList<Contactos> contactos) {
		this.contactos = contactos;
	}
	public final Conexion getConexion() {
		return conexion;
	}
	public final void setConexion(Conexion conexion) {
		this.conexion = conexion;
	}
	
	//CONSULTAS
	public void mostrarContactos() {
		for(Contactos c : this.contactos) {
			c.mostrarContacto();
			System.out.println("-------------------------------------------");
		}
	}
	
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
	
	
	
public static void main(String[] args) {
		
		ArrayList<Contactos> contactos = new ArrayList<Contactos>();
		Contactos c1 = new Contactos(1,"Chema", "Martinez", "Barquero","himno","Chema@gmasasdail.com",6172923);
		Contactos c2 = new Contactos(2,"Chemsa", "Martinasez", "Barqueadsro","hidasmno","Chema@gmail.com",6172923);
		
		contactos.add(c1);
		contactos.add(c2);
		
		ListadeContacto lc = new ListadeContacto (contactos);
		
		lc.mostrarContactos();
		
		lc.buscarPor(6172923);
		lc.buscarPor("Chema@gmasasdail.com");
		
	}




	
}
