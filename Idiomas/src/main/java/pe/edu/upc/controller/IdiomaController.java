package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Idioma;
import pe.edu.upc.service.IIdiomaService;

@Named
@RequestScoped
public class IdiomaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IIdiomaService serv;
	private List<Idioma> lista;
	private Idioma idioma;
	
	
	@PostConstruct
	public void init() {
		this.lista = new ArrayList<Idioma>();
		this.idioma = new Idioma();
		this.listarIdiomas();
	}
	
	public String nuevo() {
		this.setIdioma(new Idioma());
		return "idioma.xhtml";
	}
	
	public String editar(Idioma idioma) {
		this.setIdioma(idioma);
		return "idioma.xhtml";
	}
	
	public void insertar() {
		serv.insertar(idioma);
		limpiar();
	}
	
	public void listarIdiomas() {
		lista = serv.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Idioma idioma) {
		serv.eliminar(idioma.getId());
		this.listarIdiomas();
	}

	public Idioma getIdioma() {
		return idioma;
	}

	public void setIdioma(Idioma idioma) {
		this.idioma = idioma;
	}

	public List<Idioma> getLista() {
		return lista;
	}

	public void setLista(List<Idioma> lista) {
		this.lista = lista;
	}
	
}
