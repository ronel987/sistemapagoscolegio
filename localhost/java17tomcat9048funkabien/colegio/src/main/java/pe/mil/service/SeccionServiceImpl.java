package pe.mil.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Seccion;
import pe.mil.repository.SeccionRepository;

@Service
public class SeccionServiceImpl implements SeccionService{
	
	@Autowired
	private SeccionRepository repository;

	@Override
	@Transactional
	public void insert(Seccion seccion) {
		repository.save(seccion);
		
	}

	@Override
	@Transactional
	public void update(Seccion seccion) {
		repository.save(seccion);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);
		
	}

	@Override
	@Transactional(readOnly=true)
	public Seccion findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Seccion> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<Integer> findForeign() {
		return repository.findForeign();
	}


}
