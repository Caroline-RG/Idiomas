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
@Table(name="Profesor")
public class Profesor extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el nombre del profesor.")
	@NotBlank(message="El nombre del profesor no puede estar en blanco.")
	@Size(max=50, message="El nombre del profesor debe tener como m?ximo 50 caracteres.")
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;

	@NotEmpty(message="Debes ingresar obligatoriamente el apellido del profesor.")
	@NotBlank(message="El apellido del profesor no puede estar en blanco.")
	@Size(max=50, message="El apellido del profesor debe tener como m?ximo 50 caracteres.")
	@Column(name="apellido", nullable=false, length=50)
	private String apellido;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el correo del profesor.")
	@NotBlank(message="El correo del profesor no puede estar en blanco.")
	@Size(max=50, message="El correo del profesor debe tener como m?ximo 50 caracteres.")
	@Email(message = "El correo del profesor ingresado no tiene un formato v?lido.")
	@Column(name="correo", nullable=false, length=50)
	private String correo;

	@NotEmpty(message="Debes ingresar obligatoriamente la contrase?a del profesor.")
	@NotBlank(message="La contrase?a del profesor no puede estar en blanco.")
	@Size(max=50, message="La contrase?a del profesor debe tener como m?ximo 50 caracteres.")
	@Column(name="contrasena", nullable=false, length=100)	
	private String contrasena;
	
	public Profesor() {
		super();
	}
	
	public Profesor(String nombre, String apellido, String correo, String contrasena) {
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
