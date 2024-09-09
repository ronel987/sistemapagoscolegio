package pe.mil.service;
import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.mil.entity.Usuario;
import pe.mil.repository.UsuarioRepository;
import pe.mil.service.UsuarioService;

@Service
public class UsuServiceImpl implements UsuarioService {
	@Autowired
    private UsuarioRepository usurepos; //hereda metodos de JpaRepository

	@Override
	@Transactional
	public void insert(Usuario cal) {
		usurepos.save(cal);		
	}

	@Override
	@Transactional
	public void update(Usuario cal) {
		usurepos.save(cal);		
	}

	@Override
	@Transactional
	public void delete(Integer calId) {
		usurepos.deleteById(calId);		
	}

	@Override
	@Transactional(readOnly=true)
	public Usuario findById(Integer calId) {
		return usurepos.findById(calId).orElse(null);	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Usuario> findAll() {
		return usurepos.findAll();
	}

	@Override
	@Transactional(readOnly=true)
	public Collection<Integer> usuID_UsuPago() {
		return usurepos.usuID_UsuPago();
	}
	
	
}
