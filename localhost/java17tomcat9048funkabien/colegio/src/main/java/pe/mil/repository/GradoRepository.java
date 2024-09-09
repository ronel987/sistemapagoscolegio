package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Grado;

public interface GradoRepository extends JpaRepository<Grado,Integer> {
	
	@Query(value="select g.id from grados g inner join secciones s on g.id = s.codigo_grado order by g.id",nativeQuery=true)
	public abstract Collection<Integer> findForeign();
	
}
