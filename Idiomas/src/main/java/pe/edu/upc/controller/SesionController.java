package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Sesion;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Dia;
import pe.edu.upc.service.ISesionService;
import pe.edu.upc.service.ICursoService;
import pe.edu.upc.service.IDiaService;

@Named
@RequestScoped
public class SesionController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISesionService servSesion;
	@Inject
	private ICursoService servCurso;
	@Inject
	private IDiaService servDia;
	
	private List<Sesion> listaSesion;
	private List<Curso> listaCurso;
	private List<Dia> listaDia;
	
	private Sesion sesion;
	private Curso course;
	private Dia dia;
	
	@PostConstruct
	public void init() {
		this.listaSesion = new ArrayList<Sesion>();
		this.listaCurso = new ArrayList<Curso>();
		this.listaDia = new ArrayList<Dia>();
		this.sesion = new Sesion();
		this.course = new Curso();
		this.dia = new Dia();
		this.listarSesiones();
		this.listarCursos();
		this.listarDias();
	}
	
	public String nuevo() {
		this.setSesion(new Sesion());
		return "sesion.xhtml";
	}

	public String editar(Sesion sesion) {
		this.setSesion(sesion);
		return "sesion.xhtml";
	}
	
	public void insertar() {
		servSesion.insertar(sesion);
		limpiar();
		this.listarCursos();
	}
	
	public void listarSesiones() {
		listaSesion = servSesion.listar();
	}
	
	public void listarCursos() {
		listaCurso = servCurso.listar();
	}
	
	public void listarDias() {
		listaDia = servDia.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Sesion sesion) {
		servSesion.eliminar(sesion.getId());
		this.listarCursos();
	}

	public List<Sesion> getListaSesion() {
		return listaSesion;
	}

	public void setListaSesion(List<Sesion> listaSesion) {
		this.listaSesion = listaSesion;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public List<Dia> getListaDia() {
		return listaDia;
	}

	public void setListaDia(List<Dia> listaDia) {
		this.listaDia = listaDia;
	}
	
	public Sesion getSesion() {
		return sesion;
	}

	public void setSesion(Sesion sesion) {
		this.sesion = sesion;
	}

	public Curso getCourse() {
		return course;
	}

	public void setCourse(Curso course) {
		this.course = course;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}
	
}
