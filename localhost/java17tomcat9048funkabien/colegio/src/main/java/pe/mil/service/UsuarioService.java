package pe.mil.service;
import java.util.Collection;

import pe.mil.entity.Calendario;
import pe.mil.entity.Usuario;

public interface UsuarioService {
	public abstract void insert(Usuario usuario);
	public abstract void update(Usuario usuario);
	public abstract void delete(Integer calId);
	public abstract Usuario findById(Integer calId);
	public abstract Collection<Usuario> findAll();
	public abstract Collection<Integer> usuID_UsuPago();
}
