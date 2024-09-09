package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Alumno;


public interface AlumnoService {
	
	public abstract void insert(Alumno alumno);
	public abstract void update(Alumno alumno);
	public abstract void delete(Integer Id);
	public abstract Alumno findById(Integer Id);
	public abstract Collection<Alumno>findAll();
	public abstract Collection<Integer> aluID_AluMatricula();

}
