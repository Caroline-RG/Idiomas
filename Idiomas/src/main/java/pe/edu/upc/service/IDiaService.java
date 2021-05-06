package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Dia;

public interface IDiaService {
	public void insertar(Dia dia);
	public void eliminar(int id);
	public List<Dia> listar();
}
