package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Idioma;

public interface IIdiomaService {
	public void insertar(Idioma idioma);
	public void eliminar(int id);
	public List<Idioma> listar();
}
