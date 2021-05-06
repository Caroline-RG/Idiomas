package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.ICursoDao;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.service.ICursoService;

@Named
@RequestScoped
public class CursoServiceImpl implements ICursoService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private ICursoDao dao;
	
	@Override
	public void insertar(Curso curso) {
		dao.insertar(curso);
	}

	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Curso> listar() {
		return dao.listar();
	}

}
