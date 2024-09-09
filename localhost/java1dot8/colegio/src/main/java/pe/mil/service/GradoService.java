package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Grado;

public interface GradoService {
	
	public abstract void insert(Grado grado);
	public abstract void update(Grado grado);
	public abstract void delete(Integer id);
	public abstract Grado findById(Integer id);
	public abstract Collection<Grado> findAll();
	public abstract Collection<Integer> findForeign();

}
