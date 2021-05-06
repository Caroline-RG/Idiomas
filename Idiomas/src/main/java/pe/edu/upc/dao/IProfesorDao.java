package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Profesor;

public interface IProfesorDao {
	public void insertar(Profesor profesor);
	public void eliminar(int id);
	public List<Profesor> listar();
}
