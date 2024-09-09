package pe.mil.service;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Pago;
import pe.mil.repository.PagoRepository;
import pe.mil.service.PagoService;


@Service
public class PagoServiceImpl implements PagoService {
	@Autowired
    private PagoRepository pagorepos;

	@Override
	@Transactional
	public void insert(Pago pago) {
		pagorepos.save(pago);		
	}

	@Override
	@Transactional
	public void update(Pago cal) {
		pagorepos.save(cal);		
	}

	@Override
	@Transactional
	public void delete(Integer calId) {
		pagorepos.deleteById(calId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Pago findById(Integer calId) {
		return pagorepos.findById(calId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Pago> findAll() {
		return pagorepos.findAll();
	}

	
}
