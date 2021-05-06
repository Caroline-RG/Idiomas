package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IProfesorDao;
import pe.edu.upc.entity.Profesor;

public class ProfesorDaoImpl implements IProfesorDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Profesor profesor) {
		em.merge(profesor);
	}

	@Transactional
	@Override
	public void eliminar(int id) {
		Profesor profesor = new Profesor();
		profesor = em.getReference(Profesor.class, id);
		em.remove(profesor);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Profesor> listar() {
		List<Profesor> lista = new ArrayList<Profesor>();
		Query q = em.createQuery("select m from Profesor m");
		lista = (List<Profesor>) q.getResultList();
		return lista;
	}
}
