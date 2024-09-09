package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Ano_Escolar;

public interface Ano_EscolarRepository extends JpaRepository<Ano_Escolar,Integer>{
	
	@Query(value="select a.id from ano_escolares a inner join grado g on a.id = g.codigo_ae order by a.id",nativeQuery=true)
	public abstract Collection<Integer> findForeign();

}
