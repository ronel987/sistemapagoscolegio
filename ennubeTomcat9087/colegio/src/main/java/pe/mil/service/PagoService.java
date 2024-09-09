package pe.mil.service;
import java.util.Collection;
import pe.mil.entity.Pago;


public interface PagoService {
	public abstract void insert(Pago pago);
	public abstract void update(Pago pago);
	public abstract void delete(Integer calId);
	public abstract Pago findById(Integer calId);
	public abstract Collection<Pago> findAll();
}
