package Agenda;

/**
 * 
 * Esta clase construye un nuevo "Contacto" con sus distintos atributos
 * @author Chema
 *
 */

public class Contactos {

	/**
	 * Atributos de contactos
	 */
	
	private int id;
	private String nombre;
	private String apellido1;
	private String apellido2;
	private String direccion;
	private String email;
	private int telefono;
	
	/*
	 * Constructores
	 */
	
	public Contactos(int id,String nombre, String apellido1, String apellido2, String direccion, String email, int telefono) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.direccion = direccion;
		this.email = email;
		this.telefono = telefono;
	}
	
	public Contactos() {
		super();
		this.id = 0;
		this.nombre = "";
		this.apellido1 = "";
		this.apellido2 = "";
		this.direccion = "";
		this.email = "";
		this.telefono = 0;
	}
	
	public Contactos(Contactos c) {
		super();
		this.id = c.id;
		this.nombre = c.nombre;
		this.apellido1 = c.apellido1;
		this.apellido2 =c.apellido2;
		this.direccion = c.direccion;
		this.email = c.email;
		this.telefono = c.telefono;
	}
	


	/**
	 * Obtener el parametro nombre de la clase
	 * @return Nos devuelve el nombre
	 */
	
	public final String getNombre() {
		return nombre;
	}
	/**
	 * Modifica el parametro nombre
	 * @param nombre . Añadimos un nuevo parametro 
	 */

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Podemos pedirle que nos de el apellido1 en forma de String 
	 * @return . Devuelve apellido1
	 */

	public final String getApellido1() {
		return apellido1;
	}

	/**
	 * Modifica el parametro apellido1, cambiandolo al nuevo String que nosotros hemos añadido
	 * @param apellido1 . Añadimos un nuevo primer apelldio
	 */
	public final void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * Manera de obeneter apellido2
	 * @return nos devuelve el parametro apellido2
	 */

	public final String getApellido2() {
		return apellido2;
	}
	
	/**
	 * Cambiamos el parametro apellido2
	 * @param apellido2 cambiamos el parametro apellido2, por el añadido
	 */
	public final void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}
	/**
	 * Obetner el parametro direccion
	 * @return nos devuelve un String con el parametro Direccion
	 */
	public final String getDireccion() {
		return direccion;
	}

	/**
	 * Sustituir el parametro de dirección
	 * @param direccion nuevo valor de direccion
	 */
	public final void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	/**
	 * Obtener el parametro "email"
	 * @return nos devuelve el parametro email
	 */
	public final String getEmail() {
		return email;
	}
	/**
	 * Sustituir el parametro email
	 * @param email añadimos email
	 */
	public final void setEmail(String email) {
		this.email = email;
	}
	/**
	 * Obtener el parametro telefono
	 * @return nos devuelve parametro telefono
	 */
	public final int getTelefono() {
		return telefono;
	}
	/**
	 * Cambiar el parametro telefono
	 * @param telefono añadimos nuevo telefono
	 */
	public final void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	/**
	 * Nos devuelve el parametro ID
	 * @return devuelve parametro ID
	 */
	public final int getId() {
		return id;
	}
	
	
/**
 * Metodo que sirve para mostrar los datos del contacto
 */
	public void mostrarContacto() {
		System.out.println(" Nombre y apellidos: " + this.nombre + " " + this.apellido1 + " " + this.apellido2);
		System.out.println("Direcion: " + this.direccion);
		System.out.println("Correo Electronico: " + this.email);
		System.out.println("Telefono: " + this.telefono);
	}

	
	/**
	 * Añadimos un "hasCode" en el id para que sea único y no se repita.
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Contactos other = (Contactos) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
