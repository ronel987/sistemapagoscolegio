package pe.mil.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.mil.entity.Alumno;
import pe.mil.repository.AlumnoRepository;

@Service
public class AlumnoServiceImpl implements AlumnoService{
	
	@Autowired
	private AlumnoRepository alumpos;
	
	@Override
	@Transactional
	public void insert(Alumno alumno) {
		alumpos.save(alumno);		
	}

	@Override
	@Transactional
	public void update(Alumno alumno) {
		alumpos.save(alumno);		
	}

	@Override
	@Transactional
	public void delete(Integer Id) {
		alumpos.deleteById(Id);		
	}

	@Override
	@Transactional(readOnly=true)
	public Alumno findById(Integer Id) {
		return alumpos.findById(Id).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Alumno> findAll() {
		return alumpos.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Integer> aluID_AluMatricula() {
		return alumpos.aluID_AluMatricula();
	}

}
