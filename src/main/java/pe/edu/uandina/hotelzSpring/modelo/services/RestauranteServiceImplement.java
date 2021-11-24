package pe.edu.uandina.hotelzSpring.modelo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.Restaurante;
import pe.edu.uandina.hotelzSpring.modelo.dao.IRestauranteDao;
import java.util.List;

@Service
public class RestauranteServiceImplement implements  IRestauranteService{

    @Autowired
    private IRestauranteDao restauranteDao;

    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<Restaurante> findAll() {
        return (List<Restaurante>) restauranteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Restaurante findById(long id) {

        return restauranteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Restaurante save(Restaurante restaurante) {
        return restauranteDao.save(restaurante);
    }

    @Override
    @Transactional
    public void delete(long id) {
        restauranteDao.deleteById(id);
    }
}
