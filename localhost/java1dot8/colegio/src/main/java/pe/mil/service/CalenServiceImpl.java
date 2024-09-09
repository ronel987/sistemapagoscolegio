package pe.mil.service;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Calendario;
import pe.mil.repository.CalendarioRepository;
import pe.mil.service.CalendarioService;


@Service
public class CalenServiceImpl implements CalendarioService {
	@Autowired
    private CalendarioRepository calrepos; //hereda metodos de JpaRepository

	@Override
	@Transactional
	public void insert(Calendario cal) {
		calrepos.save(cal);		
	}

	@Override
	@Transactional
	public void update(Calendario calen) {
		calrepos.save(calen);		
	}

	@Override
	@Transactional
	public void delete(Integer calId) {
		calrepos.deleteById(calId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Calendario findById(Integer calId) {
		return calrepos.findById(calId).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Calendario> findAll() {
		return calrepos.findAll();
	}

	@Override
	public Collection<Integer> calID_CalPago() {		
		return calrepos.calID_CalPago();
	}
	
	
	
}
