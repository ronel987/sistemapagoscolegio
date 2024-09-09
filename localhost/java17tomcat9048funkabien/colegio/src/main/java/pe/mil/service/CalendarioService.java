package pe.mil.service;
import java.util.Collection;
import pe.mil.entity.Calendario;


public interface CalendarioService {
	public abstract void insert(Calendario cal);
	public abstract void update(Calendario calen);
	public abstract void delete(Integer calId);
	public abstract Calendario findById(Integer calId);
	public abstract Collection<Calendario> findAll();
	public abstract Collection<Integer> calID_CalPago();
	
}
