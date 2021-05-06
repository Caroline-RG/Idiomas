package pe.edu.upc.serviceimpl;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import pe.edu.upc.dao.IIdiomaDao;
import pe.edu.upc.entity.Idioma;
import pe.edu.upc.service.IIdiomaService;

@Named
@RequestScoped
public class IdiomaServiceImpl implements IIdiomaService, Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private IIdiomaDao dao;
	
	@Override
	public void insertar(Idioma idioma) {
		dao.insertar(idioma);
	}
	
	@Override
	public void eliminar(int id) {
		dao.eliminar(id);
	}
	
	@Override
	public List<Idioma> listar() {
		return dao.listar();
	}

}
