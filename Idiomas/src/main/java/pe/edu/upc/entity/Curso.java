package pe.edu.upc.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import javax.validation.constraints.FutureOrPresent;

@Entity
@Table(name="Curso")
public class Curso extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el nivel del curso.")
	@NotBlank(message="El nivel del curso no puede estar en blanco.")
	@Size(max=50, message="El nivel del curso debe tener como máximo 50 caracteres.")
	@Column(name="nivel", nullable=false, length=50)
	private String nivel;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el enlace del curso.")
	@NotBlank(message="El enlace del curso no puede estar en blanco.")
	@Size(max=100, message="El enlace del curso debe tener como máximo 100 caracteres.")
	@Column(name="enlace", nullable=false, length=100)
	private String enlace;
	
	@Positive(message="La duración del curso debe ser un entero positivo.")
	@Column(name="duracion", nullable=false)
	private int duracion;

	@FutureOrPresent(message="La fecha de inicio del curso no puede ser anterior a la fecha actual.")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaIni", nullable=false)
	private Date fechaIni;
	
	@FutureOrPresent(message="La fecha de fin del curso no puede ser anterior a la fecha actual.")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaFin", nullable=false)
	private Date fechaFin;
	
	@ManyToOne
	@JoinColumn(name="idIdioma", nullable=false)
	private Idioma idioma;
	
	@ManyToOne
	@JoinColumn(name="idProfesor", nullable=false)
	private Profesor profesor;
	
	public Curso() {
		super();
	}

	public Curso(String nivel, String enlace, int duracion, Date fechaIni, Date fechaFin, Idioma idioma, Profesor profesor) {
		super();
		this.nivel = nivel;
		this.enlace = enlace;
		this.duracion = duracion;
		this.fechaIni = fechaIni;
		this.fechaFin = fechaFin;
		this.idioma = idioma;
		this.profesor = profesor;
	}

	public String getNivel() {
		return nivel;
	}

	public void setNivel(String nivel) {
		this.nivel = nivel;
	}

	public String getEnlace() {
		return enlace;
	}

	public void setEnlace(String enlace) {
		this.enlace = enlace;
	}

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public Date getFechaIni() {
		return fechaIni;
	}

	public void setFechaIni(Date fechaIni) {
		this.fechaIni = fechaIni;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}
	
}
