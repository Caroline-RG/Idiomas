package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IProfesorDao;
import pe.edu.upc.entity.Profesor;
import pe.edu.upc.service.IProfesorService;

@Named
@RequestScoped
public class ProfesorServiceImpl implements IProfesorService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IProfesorDao dao;
	
	@Override
	public void insertar(Profesor profesor) {
		dao.insertar(profesor);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Profesor> listar() {
		return dao.listar();
	}

}
