package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Entity
@Table(name="Alumno")
public class Alumno extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el nombre del alumno.")
	@NotBlank(message="El nombre del alumno no puede estar en blanco.")
	@Size(max=50, message="El nombre del alumno debe tener como máximo 50 caracteres.")
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;

	@NotEmpty(message="Debes ingresar obligatoriamente el apellido del alumno.")
	@NotBlank(message="El apellido del alumno no puede estar en blanco.")
	@Size(max=50, message="El apellido del alumno debe tener como máximo 50 caracteres.")
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el correo del alumno.")
	@NotBlank(message="El correo del alumno no puede estar en blanco.")
	@Size(max=50, message="El correo del alumno debe tener como máximo 50 caracteres.")
	@Email(message = "El correo del alumno ingresado no tiene un formato válido.")
	@Column(name="correo", nullable=false, length=50)
	private String correo;

	@NotEmpty(message="Debes ingresar obligatoriamente la contraseña del alumno.")
	@NotBlank(message="La contraseña del alumno no puede estar en blanco.")
	@Size(max=50, message="La contraseña del alumno debe tener como máximo 50 caracteres.")
	@Column(name="contrasena", nullable=false, length=100)	
	private String contrasena;
	
	public Alumno() {
		super();
	}
	
	public Alumno(String nombre, String apellido, String correo, String contrasena) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.contrasena = contrasena;
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

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
	}
	
}
