package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Ano_Escolar;

public interface Ano_EscolarService {
	
	public abstract void insert(Ano_Escolar ano_escolar);
	public abstract void update(Ano_Escolar ano_escolar);
	public abstract void delete(Integer id);
	public abstract Ano_Escolar findById(Integer id);
	public abstract Collection<Ano_Escolar> findAll();
	public abstract Collection<Integer> findForeign();

}
