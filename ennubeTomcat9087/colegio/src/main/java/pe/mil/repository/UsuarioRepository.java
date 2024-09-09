package pe.mil.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pe.mil.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
	//lista de UsuarioID que estan en la tabla pagos
    @Query(value="select u.id as 'usuario_id'"
    		+ "from pagos pa\r\n"
    		+ "inner join usuarios u on u.id=pa.usuario_id \r\n"	    		
    		+ "order by u.id",nativeQuery=true)	    
    public abstract Collection<Integer> usuID_UsuPago();
}
