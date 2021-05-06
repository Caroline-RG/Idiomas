package pe.edu.upc.daoimpl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import pe.edu.upc.dao.IDiaDao;
import pe.edu.upc.entity.Dia;

public class DiaDaoImpl implements IDiaDao, Serializable {

	private static final long serialVersionUID = 1L;
	
	@PersistenceContext(unitName="b")
	private EntityManager em;

	@Transactional
	@Override
	public void insertar(Dia dia) {
		em.merge(dia);
	}

	@Transactional
	@Override
	public void eliminar(int id) {
		Dia dia = new Dia();
		dia = em.getReference(Dia.class, id);
		em.remove(dia);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Dia> listar() {
		List<Dia> lista = new ArrayList<Dia>();
		Query q = em.createQuery("select m from Dia m");
		lista = (List<Dia>) q.getResultList();
		return lista;
	}
}
