package pe.edu.upc.dao;

import java.util.List;

import pe.edu.upc.entity.Curso;
import pe.edu.upc.entity.Sesion;

public interface ISesionDao {
	public void insertar(Sesion sesion);
	public void eliminar(int id);
	public List<Sesion> listar();
	public List<Sesion> listarPorCurso(Curso curso);
}
