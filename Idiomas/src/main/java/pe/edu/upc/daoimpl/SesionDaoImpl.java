package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ISesionDao;
import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Sesion;

public class SesionDaoImpl implements ISesionDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Sesion sesion) {
		em.merge(sesion);
	}
	
	@Transactional
	@Override
	public void eliminar(int id) {
		Sesion sesion = new Sesion();
		sesion = em.getReference(Sesion.class, id);
		em.remove(sesion);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Sesion> listar() {
		List<Sesion> lista = new ArrayList<Sesion>();
		Query q = em.createQuery("select m from Sesion m");
		lista = (List<Sesion>) q.getResultList();
		return lista;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Sesion> listarPorCurso(Curso curso) {
		List<Sesion> lista = new ArrayList<Sesion>();
		Query q = em.createQuery("select m from Sesion m where m.curso = :curso").setParameter("curso", curso);
		lista = (List<Sesion>) q.getResultList();
		return lista;
	}
}
