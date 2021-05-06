package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Profesor;

public interface IProfesorService {
	public void insertar(Profesor profesor);
	public void eliminar(int id);
	public List<Profesor> listar();
}
