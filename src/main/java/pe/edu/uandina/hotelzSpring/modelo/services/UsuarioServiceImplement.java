package pe.edu.uandina.hotelzSpring.modelo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.Usuario;
import pe.edu.uandina.hotelzSpring.modelo.dao.IUsuarioDao;
import java.util.List;

@Service
public class UsuarioServiceImplement implements IUsuarioService{

    //para acceder al Dao necesito @Autowired que genere una instancia en automatico en este caso a ICLienteDao y por consiguiente a la DB
    @Autowired
    private IUsuarioDao usuarioDao;


    //para hacer uso de los metodos tenemos q usar la instancia nueva de CRUD
    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<Usuario> findAll() {
        return (List<Usuario>) usuarioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario findById(long id) {

        return usuarioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Usuario save(Usuario usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    @Transactional
    public void delete(long id) {
        usuarioDao.deleteById(id);
    }
}
