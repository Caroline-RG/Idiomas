package pe.edu.upc.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.entity.Dia;
import pe.edu.upc.service.IDiaService;

@Named
@RequestScoped
public class DiaController implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private IDiaService serv;
	private List<Dia> lista;
	private Dia dia;
	
	
	@PostConstruct
	public void init() {
		this.lista = new ArrayList<Dia>();
		this.dia = new Dia();
		this.listarDias();
	}
	
	public String nuevo() {
		this.setDia(new Dia());
		return "dia.xhtml";
	}
	
	public String editar(Dia dia) {
		this.setDia(dia);
		return "dia.xhtml";
	}
	
	public void insertar() {
		serv.insertar(dia);
		limpiar();
	}
	
	public void listarDias() {
		lista = serv.listar();
	}
	
	public void limpiar() {
		this.init();
	}
	
	public void eliminar(Dia dia) {
		serv.eliminar(dia.getId());
		this.listarDias();
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	public List<Dia> getLista() {
		return lista;
	}

	public void setLista(List<Dia> lista) {
		this.lista = lista;
	}
	
}
