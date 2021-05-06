package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Profesor;
import pe.edu.upc.service.IProfesorService;

@Named
@RequestScoped
public class ProfesorController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProfesorService serv;
	private List<Profesor> lista;
	private Profesor profesor;
	
	
	@PostConstruct
	public void init() {
		this.lista = new ArrayList<Profesor>();
		this.profesor = new Profesor();
		this.listarProfesors();
	}
	
	public String nuevo() {
		this.setProfesor(new Profesor());
		return "profesor.xhtml";
	}
	
	public String editar(Profesor profesor) {
		this.setProfesor(profesor);
		return "profesor.xhtml";
	}
	
	public void insertar() {
		serv.insertar(profesor);
		limpiar();
	}
	
	public void listarProfesors() {
		lista = serv.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Profesor profesor) {
		serv.eliminar(profesor.getId());
		this.listarProfesors();
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public List<Profesor> getLista() {
		return lista;
	}

	public void setLista(List<Profesor> lista) {
		this.lista = lista;
	}
	
}
