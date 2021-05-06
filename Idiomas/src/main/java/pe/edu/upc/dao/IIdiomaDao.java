package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Idioma;

public interface IIdiomaDao {
	public void insertar(Idioma idioma);
	public void eliminar(int id);
	public List<Idioma> listar();
}
