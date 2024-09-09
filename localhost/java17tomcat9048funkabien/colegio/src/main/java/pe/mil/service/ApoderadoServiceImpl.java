package pe.mil.service;

import java.util.Collection;

import pe.mil.entity.Apoderado;
import pe.mil.repository.ApoderadoRepository;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;




@Service
public class ApoderadoServiceImpl implements ApoderadoService{
	
	@Autowired
	private ApoderadoRepository apodepos;
	
	@Override
	@Transactional
	public void insert(Apoderado apoderado) {
		apodepos.save(apoderado);
	}
	
	@Override
	@Transactional
	public void update(Apoderado apoderado) {
		apodepos.save(apoderado);		
	}

	@Override
	@Transactional
	public void delete(Integer Dni) {
		apodepos.deleteById(Dni);		
	}

	@Override
	@Transactional(readOnly=true)
	public Apoderado findById(Integer Dni) {
		return apodepos.findById(Dni).orElse(null);
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Apoderado> findAll() {
		return apodepos.findAll();
	}
	
	@Override
	@Transactional(readOnly=true)
	public Collection<Integer> Dni_ApoAlu() {		
		return apodepos.Dni_ApoAlu();
	}
	
}
