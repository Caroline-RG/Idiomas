package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Matricula;

public interface IMatriculaService {
	public void insertar(Matricula matricula);
	public void eliminar(int id);
	public List<Matricula> listar();
}
