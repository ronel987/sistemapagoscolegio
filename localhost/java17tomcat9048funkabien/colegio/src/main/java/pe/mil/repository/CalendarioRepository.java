package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Calendario;

public interface CalendarioRepository extends JpaRepository<Calendario,Integer> {
	
	
	//lista de CalendID que estan en la tabla pagos
    @Query(value="select ca.id as 'calendario_id'"
    		+ "from pagos pa\r\n"
    		+ "inner join calendarios ca on ca.id=pa.calendario_id \r\n"	    		
    		+ "order by ca.id",nativeQuery=true)	    
    public abstract Collection<Integer> calID_CalPago();

}
