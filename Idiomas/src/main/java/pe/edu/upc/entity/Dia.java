package pe.edu.upc.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Dia")
public class Dia extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el nombre del d�a.")
	@NotBlank(message="El nombre del d�a no puede estar en blanco.")
	@Size(max=50, message="El nombre del d�a debe tener como m�ximo 50 caracteres.")
	@Column(name="nombre", nullable=false, length=50)
	private String nombre;
	
	public Dia() {
		super();
	}
	
	public Dia(String nombre) {
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
