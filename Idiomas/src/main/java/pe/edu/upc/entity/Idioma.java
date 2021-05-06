package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Idioma")
public class Idioma extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el nombre del idioma.")
	@NotBlank(message="El nombre del idioma no puede estar en blanco.")
	@Size(max=50, message="El nombre del idioma debe tener como máximo 50 caracteres.")
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	public Idioma() {
		super();
	}
	
	public Idioma(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
