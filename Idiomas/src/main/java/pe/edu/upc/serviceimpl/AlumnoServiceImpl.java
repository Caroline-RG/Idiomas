package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IAlumnoDao;
import pe.edu.upc.entity.Alumno;
import pe.edu.upc.service.IAlumnoService;

@Named
@RequestScoped
public class AlumnoServiceImpl implements IAlumnoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IAlumnoDao dao;
	
	@Override
	public void insertar(Alumno alumno) {
		dao.insertar(alumno);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Alumno> listar() {
		return dao.listar();
	}

}
