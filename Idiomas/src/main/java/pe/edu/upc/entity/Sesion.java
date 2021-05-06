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

@Entity
@Table(name="Sesion")
public class Sesion extends Master implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Temporal(TemporalType.TIME)
	@Column(name="horaIni", nullable=false)
	private Date horaIni;
	
	@Temporal(TemporalType.TIME)
	@Column(name="horaFin", nullable=false)
	private Date horaFin;
	
	@ManyToOne
	@JoinColumn(name="idCurso", nullable=false)
	private Curso curso;
	
	@ManyToOne
	@JoinColumn(name="idDia", nullable=false)
	private Dia dia;
	
	public Sesion() {
		super();
	}
	
	public Sesion(Date horaIni, Date horaFin, Curso curso, Dia dia) {
		super();
		this.horaIni = horaIni;
		this.horaFin = horaFin;
		this.curso = curso;
		this.dia = dia;
	}

	public Date getHoraIni() {
		return horaIni;
	}

	public void setHoraIni(Date horaIni) {
		this.horaIni = horaIni;
	}

	public Date getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(Date horaFin) {
		this.horaFin = horaFin;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}
	
}
