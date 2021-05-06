package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Alumno;
import pe.edu.upc.service.IAlumnoService;

@Named
@RequestScoped
public class AlumnoController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IAlumnoService serv;
	private List<Alumno> lista;
	private Alumno alumno;
	
	
	@PostConstruct
	public void init() {
		this.lista = new ArrayList<Alumno>();
		this.alumno = new Alumno();
		this.listarAlumnos();
	}
	
	public String nuevo() {
		this.setAlumno(new Alumno());
		return "alumno.xhtml";
	}
	
	public String editar(Alumno alumno) {
		this.setAlumno(alumno);
		return "alumno.xhtml";
	}
	
	public void insertar() {
		serv.insertar(alumno);
		limpiar();
	}
	
	public void listarAlumnos() {
		lista = serv.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Alumno alumno) {
		serv.eliminar(alumno.getId());
		this.listarAlumnos();
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public List<Alumno> getLista() {
		return lista;
	}

	public void setLista(List<Alumno> lista) {
		this.lista = lista;
	}
	
}
