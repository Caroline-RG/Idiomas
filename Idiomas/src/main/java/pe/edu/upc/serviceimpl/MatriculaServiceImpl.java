package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IMatriculaDao;
import pe.edu.upc.entity.Matricula;
import pe.edu.upc.service.IMatriculaService;

@Named
@RequestScoped
public class MatriculaServiceImpl implements IMatriculaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IMatriculaDao dao;
	
	@Override
	public void insertar(Matricula matricula) {
		dao.insertar(matricula);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Matricula> listar() {
		return dao.listar();
	}

}
