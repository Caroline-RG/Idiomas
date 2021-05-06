package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.ICursoDao;
import pe.edu.upc.entity.Curso;

public class CursoDaoImpl implements ICursoDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Curso curso) {
		em.merge(curso);
	}

	@Transactional
	@Override
	public void eliminar(int id) {
		Curso curso = new Curso();
		curso = em.getReference(Curso.class, id);
		em.remove(curso);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Curso> listar() {
		List<Curso> lista = new ArrayList<Curso>();
		Query q = em.createQuery("select m from Curso m");
		lista = (List<Curso>) q.getResultList();
		return lista;
	}
}
