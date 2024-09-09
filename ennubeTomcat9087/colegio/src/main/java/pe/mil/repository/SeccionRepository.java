package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Seccion;

public interface SeccionRepository extends JpaRepository<Seccion,Integer> {
	
	@Query(value="select s.codigo_grado as 'cg' from seccion s inner join grado g on s.codigo_grado=g.id order by s.codigo_grado",nativeQuery=true)
	public abstract Collection<Integer> findForeign();
	
}
