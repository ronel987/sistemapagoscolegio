package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Seccion;

public interface SeccionService {
	
	public abstract void insert(Seccion seccion);
	public abstract void update(Seccion seccion);
	public abstract void delete(Integer id);
	public abstract Seccion findById(Integer id);
	public abstract Collection<Seccion> findAll();
	public abstract Collection<Integer> findForeign();
	
}
