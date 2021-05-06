package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.Alumno;

public interface IAlumnoService {
	public void insertar(Alumno alumno);
	public void eliminar(int id);
	public List<Alumno> listar();
}
