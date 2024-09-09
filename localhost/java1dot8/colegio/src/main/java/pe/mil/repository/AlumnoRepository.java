package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Alumno;

public interface AlumnoRepository extends JpaRepository<Alumno, Integer> {
	
	@Query(value="select al.id as 'alumno_id' from alumnos al inner join matriculas a on al.id = a.codigo_alumno order by al.id",nativeQuery=true)
	public abstract Collection<Integer> aluID_AluMatricula();

}
