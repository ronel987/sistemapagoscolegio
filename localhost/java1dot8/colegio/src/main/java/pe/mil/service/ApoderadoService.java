package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Apoderado;

public interface ApoderadoService {
	
	public abstract void insert(Apoderado apoderado);
	public abstract void update(Apoderado apoderado);
	public abstract void delete(Integer Dni);
	public abstract Apoderado findById(Integer Dni);
	public abstract Collection<Apoderado>findAll();
	public abstract Collection<Integer> Dni_ApoAlu();

}
