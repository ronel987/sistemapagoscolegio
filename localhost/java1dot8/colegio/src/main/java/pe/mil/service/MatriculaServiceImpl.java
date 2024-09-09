package pe.mil.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Matricula;
import pe.mil.repository.MatriculaRepository;

@Service
public class MatriculaServiceImpl implements MatriculaService{
	
	@Autowired
	private MatriculaRepository matripos;
	
	@Override
	@Transactional
	public void insert(Matricula matricula) {
		matripos.save(matricula);		
	}

	@Override
	@Transactional
	public void update(Matricula matricula) {
		matripos.save(matricula);		
	}

	@Override
	@Transactional
	public void delete(Integer Id) {
		matripos.deleteById(Id);		
	}

	@Override
	@Transactional(readOnly=true)
	public Matricula findById(Integer Id) {
		return matripos.findById(Id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Matricula> findAll() {
		return matripos.findAll();
	}

}
