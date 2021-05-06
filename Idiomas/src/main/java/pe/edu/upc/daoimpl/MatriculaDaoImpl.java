package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IMatriculaDao;
import pe.edu.upc.entity.Matricula;

public class MatriculaDaoImpl implements IMatriculaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Matricula matricula) {
		em.merge(matricula);
	}
	
	@Transactional
	@Override
	public void eliminar(int id) {
		Matricula matricula = new Matricula();
		matricula = em.getReference(Matricula.class, id);
		em.remove(matricula);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Matricula> listar() {
		List<Matricula> lista = new ArrayList<Matricula>();
		Query q = em.createQuery("select m from Matricula m");
		lista = (List<Matricula>) q.getResultList();
		return lista;
	}
}
