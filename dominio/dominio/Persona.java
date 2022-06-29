package dominio;

import java.util.ArrayList;

public class Persona {
	private String nombre;
	private String apellido;
	private String dni;
	
	
	public Persona(String nombre, String apellido, String dni) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
	}
	

	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		if (apellido == null || nombre==null) {
			if (other.apellido != null || other.nombre !=null)
				return false;
		} else if (!apellido.equals(other.apellido) || !nombre.equals(other.nombre))
			return false;
		
		return true;
	}



	
}

