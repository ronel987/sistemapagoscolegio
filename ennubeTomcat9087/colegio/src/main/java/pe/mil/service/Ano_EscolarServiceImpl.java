package pe.mil.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Ano_Escolar;
import pe.mil.repository.Ano_EscolarRepository;

@Service
public class Ano_EscolarServiceImpl implements Ano_EscolarService {
	
	@Autowired
	private Ano_EscolarRepository repository;

	@Override
	@Transactional
	public void insert(Ano_Escolar ano_escolar) {
		repository.save(ano_escolar);
		
	}

	@Override
	@Transactional
	public void update(Ano_Escolar ano_escolar) {
		repository.save(ano_escolar);
		
	}

	@Override
	@Transactional
	public void delete(Integer id) {
		repository.deleteById(id);	
		
	}

	@Override
	@Transactional(readOnly=true)
	public Ano_Escolar findById(Integer id) {
		return repository.findById(id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Ano_Escolar> findAll() {
		return repository.findAll();
	}

	@Override
	public Collection<Integer> findForeign() {
		return repository.findForeign();
	}

}
