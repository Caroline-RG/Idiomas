package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Matricula;

public interface IMatriculaDao {
	public void insertar(Matricula matricula);
	public void eliminar(int id);
	public List<Matricula> listar();
}
