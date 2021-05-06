package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ISesionDao;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Sesion;
import pe.edu.upc.service.ISesionService;

@Named
@RequestScoped
public class SesionServiceImpl implements ISesionService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ISesionDao dao;
	
	@Override
	public void insertar(Sesion sesion) {
		dao.insertar(sesion);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Sesion> listar() {
		return dao.listar();
	}

	@Override
	public List<Sesion> listarPorCurso(Curso curso) {
		return dao.listarPorCurso(curso);
	}
	
}
