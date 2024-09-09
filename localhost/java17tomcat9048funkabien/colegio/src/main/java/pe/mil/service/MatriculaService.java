package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Matricula;

public interface MatriculaService {
	
	public abstract void insert(Matricula matricula);
	public abstract void update(Matricula matricula);
	public abstract void delete(Integer Id);
	public abstract Matricula findById(Integer Id);
	public abstract Collection<Matricula>findAll();

}
