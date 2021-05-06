package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Curso;

public interface ICursoDao {
	public void insertar(Curso curso);
	public void eliminar(int id);
	public List<Curso> listar();
}
