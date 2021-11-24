package pe.edu.uandina.hotelzSpring.modelo.services;
import pe.edu.uandina.hotelzSpring.modelo.Restaurante;
import java.util.List;

public interface IRestauranteService {

    public List<Restaurante> findAll();
    public  Restaurante findById(long id);
    public  Restaurante save(Restaurante restaurante);
    public  void delete(long id);
}
