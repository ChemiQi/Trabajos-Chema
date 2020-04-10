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
	 * Coge el nombre
	 */

	
	public final String getNombre() {
		return nombre;
	}
	/**
	 * 
	 * @param nombre . Un nombre que queremos añadir
	 */

	public final void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return . Devuelve un apellido
	 */

	public final String getApellido1() {
		return apellido1;
	}

	/**
	 * @param apellido1 . Añadimos un nuevo primer apelldio
	 */
	public final void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}
	/**
	 * @return nos devuelve el segundo apellido
	 */

	public final String getApellido2() {
		return apellido2;
	}

	public final void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public final String getDireccion() {
		return direccion;
	}

	public final void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public final String getEmail() {
		return email;
	}

	public final void setEmail(String email) {
		this.email = email;
	}

	public final int getTelefono() {
		return telefono;
	}

	public final void setTelefono(int telefono) {
		this.telefono = telefono;
	}
	public final int getId() {
		return id;
	}

	public final void setId(int id) {
		this.id = id;
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
