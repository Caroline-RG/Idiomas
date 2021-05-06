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
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Entity
@Table(name="Matricula")
public class Matricula extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message="Debes ingresar obligatoriamente el comprobante de pago.")
	@NotBlank(message="El comprobante de pago no puede estar en blanco.")
	@Size(max=50, message="El comprobante de pago debe tener como máximo 50 caracteres.")
	@Column(name="comprobante", nullable=false, length=50)
	private String comprobante;
	
	@PastOrPresent(message="La fecha de pago no puede ser posterior a la fecha actual.")
	@Temporal(TemporalType.DATE)
	@Column(name="fechaPago", nullable=false)
	private Date fechaPago;
	
	@Positive(message="El monto debe ser una cantidad positiva.")
	@Column(name="monto", nullable=false)
	private float monto;
	
	@ManyToOne
	@JoinColumn(name="idCurso", nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="idAlumno", nullable=false)
	private Alumno alumno;
	
	public Matricula() {
		super();
	}
	
	public Matricula(String comprobante, Date fechaPago, float monto, Curso curso, Alumno alumno) {
		super();
		this.comprobante = comprobante;
		this.fechaPago = fechaPago;
		this.monto = monto;
		this.curso = curso;
		this.alumno = alumno;
	}

	public String getComprobante() {
		return comprobante;
	}

	public void setComprobante(String comprobante) {
		this.comprobante = comprobante;
	}

	public Date getFechaPago() {
		return fechaPago;
	}

	public void setFechaPago(Date fechaPago) {
		this.fechaPago = fechaPago;
	}

	public float getMonto() {
		return monto;
	}

	public void setMonto(float monto) {
		this.monto = monto;
	}
	
	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

}
