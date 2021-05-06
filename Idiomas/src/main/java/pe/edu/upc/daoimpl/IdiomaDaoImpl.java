package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IIdiomaDao;
import pe.edu.upc.entity.Idioma;

public class IdiomaDaoImpl implements IIdiomaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Idioma idioma) {
		em.merge(idioma);
	}

	@Transactional
	@Override
	public void eliminar(int id) {
		Idioma idioma = new Idioma();
		idioma = em.getReference(Idioma.class, id);
		em.remove(idioma);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Idioma> listar() {
		List<Idioma> lista = new ArrayList<Idioma>();
		Query q = em.createQuery("select m from Idioma m");
		lista = (List<Idioma>) q.getResultList();
		return lista;
	}
}
