package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Profesor;
import pe.edu.upc.entity.Idioma;
import pe.edu.upc.service.ICursoService;
import pe.edu.upc.service.IProfesorService;
import pe.edu.upc.service.IIdiomaService;

@Named
@RequestScoped
public class CursoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICursoService servCurso;
	@Inject
	private IIdiomaService servIdioma;
	@Inject
	private IProfesorService servProfesor;
	
	private List<Curso> listaCurso;
	private List<Idioma> listaIdioma;
	private List<Profesor> listaProfesor;
	
	private Curso curso;
	private Idioma idioma;
	private Profesor profesor;
	
	@PostConstruct
	public void init() {
		this.listaCurso = new ArrayList<Curso>();
		this.listaIdioma = new ArrayList<Idioma>();
		this.listaProfesor = new ArrayList<Profesor>();
		this.curso = new Curso();
		this.idioma = new Idioma();
		this.profesor = new Profesor();
		this.listarCursos();
		this.listarIdiomas();
		this.listarProfesores();
	}
	
	public String nuevo() {
		this.setCurso(new Curso());
		return "curso.xhtml";
	}

	public String editar(Curso curso) {
		this.setCurso(curso);
		return "curso.xhtml";
	}
	
	public void insertar() {
		servCurso.insertar(curso);
		limpiar();
		this.listarIdiomas();
		this.listarProfesores();
	}
	
	public void listarCursos() {
		listaCurso = servCurso.listar();
	}
	
	public void listarIdiomas() {
		listaIdioma = servIdioma.listar();
	}
	
	public void listarProfesores() {
		listaProfesor = servProfesor.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Curso curso) {
		servCurso.eliminar(curso.getId());
		this.listarIdiomas();
		this.listarProfesores();
	}
	
	public List<Curso> getListaCurso() {
		return listaCurso;
	}

	public void setListaCurso(List<Curso> listaCurso) {
		this.listaCurso = listaCurso;
	}

	public List<Idioma> getListaIdioma() {
		return listaIdioma;
	}

	public void setListaIdioma(List<Idioma> listaIdioma) {
		this.listaIdioma = listaIdioma;
	}

	public List<Profesor> getListaProfesor() {
		return listaProfesor;
	}

	public void setListaProfesor(List<Profesor> listaProfesor) {
		this.listaProfesor = listaProfesor;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
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
