package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Curso;

public interface ICursoService {
	public void insertar(Curso curso);
	public void eliminar(int id);
	public List<Curso> listar();
}
