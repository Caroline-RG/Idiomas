package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Matricula;
import pe.edu.upc.entity.Sesion;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Alumno;
import pe.edu.upc.service.IMatriculaService;
import pe.edu.upc.service.ISesionService;
import pe.edu.upc.service.ICursoService;
import pe.edu.upc.service.IAlumnoService;

@Named
@RequestScoped
public class MatriculaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IMatriculaService servMatricula;
	@Inject
	private IAlumnoService servAlumno;
	@Inject
	private ICursoService servCurso;
	@Inject
	private ISesionService servSesion;
	
	private List<Matricula> listaMatricula;
	private List<Alumno> listaAlumno;
	private List<Curso> listaCurso;
	private List<Sesion> listaSesion;
	
	private Matricula matricula;
	private Alumno alumno;
	private Curso curso;
	
	@PostConstruct
	public void init() {
		this.listaMatricula = new ArrayList<Matricula>();
		this.listaAlumno = new ArrayList<Alumno>();
		this.listaCurso = new ArrayList<Curso>();
		this.matricula = new Matricula();
		this.alumno = new Alumno();
		this.curso = new Curso();
		this.listarMatriculas();
		this.listarAlumnos();
		this.listarCursos();
	}
	
	public String nuevo() {
		this.setMatricula(new Matricula());
		return "matricula.xhtml";
	}
	
	public String editar(Matricula matricula) {
		this.setMatricula(matricula);
		return "matricula.xhtml";
	}
	
	public String mostrar(Matricula matricula) {
		this.setMatricula(matricula);
		this.listarSesionesPorCurso(matricula.getCurso());
		return "detMatricula.xhtml";
	}
	
	public void insertar() {
		servMatricula.insertar(matricula);
		limpiar();
		this.listarAlumnos();
		this.listarCursos();
	}
	
	public void listarMatriculas() {
		listaMatricula = servMatricula.listar();
	}
	
	public void listarAlumnos() {
		listaAlumno = servAlumno.listar();
	}
	
	public void listarCursos() {
		listaCurso = servCurso.listar();
	}
	
	public void listarSesionesPorCurso(Curso curso) {
		listaSesion = servSesion.listarPorCurso(curso);
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Matricula matricula) {
		servMatricula.eliminar(matricula.getId());
		this.listarAlumnos();
		this.listarCursos();
	}

	public List<Matricula> getListaMatricula() {
		return listaMatricula;
	}

	public void setListaMatricula(List<Matricula> listaMatricula) {
		this.listaMatricula = listaMatricula;
	}

	public List<Alumno> getListaAlumno() {
		return listaAlumno;
	}

	public void setListaAlumno(List<Alumno> listaAlumno) {
		this.listaAlumno = listaAlumno;
	}

	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public List<Sesion> getListaSesion() {
		return listaSesion;
	}

	public void setListaSesion(List<Sesion> listaSesion) {
		this.listaSesion = listaSesion;
	}
	
	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

}
