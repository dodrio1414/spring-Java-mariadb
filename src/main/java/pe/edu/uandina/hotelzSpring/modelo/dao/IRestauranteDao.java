package pe.edu.uandina.hotelzSpring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.hotelzSpring.modelo.Restaurante;

public interface IRestauranteDao extends CrudRepository<Restaurante, Long> {
}
