package pe.mil.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Grado;
import pe.mil.repository.GradoRepository;

@Service
public class GradoServiceImpl implements GradoService {
	
	@Autowired
	private GradoRepository repository;

	@Override
	@Transactional
	public void insert(Grado grado) {
		repository.save(grado);		
	}

	@Override
	@Transactional
	public void update(Grado grado) {
		repository.save(grado);		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);		
	}

	@Override
	@Transactional(readOnly=true)
	public Grado findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Grado> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<Integer> findForeign() {
		return repository.findForeign();
	}

}
