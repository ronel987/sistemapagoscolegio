package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Apoderado;

public interface ApoderadoRepository extends JpaRepository<Apoderado, Integer> {
	
	@Query(value="select a.dniapo from alumnos a inner join apoderados ap on ap.dni=a.dniapo",nativeQuery=true)	    
    public abstract Collection<Integer> Dni_ApoAlu();

}
