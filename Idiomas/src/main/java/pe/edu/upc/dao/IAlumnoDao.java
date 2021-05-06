package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Alumno;

public interface IAlumnoDao {
	public void insertar(Alumno alumno);
	public void eliminar(int id);
	public List<Alumno> listar();
}
