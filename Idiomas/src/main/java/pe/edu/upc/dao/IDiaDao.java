package pe.edu.upc.dao;

import java.util.List;
import pe.edu.upc.entity.Dia;

public interface IDiaDao {
	public void insertar(Dia dia);
	public void eliminar(int id);
	public List<Dia> listar();
}
