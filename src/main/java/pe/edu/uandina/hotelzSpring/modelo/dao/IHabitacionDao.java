package pe.edu.uandina.hotelzSpring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.hotelzSpring.modelo.Habitacion;

public interface IHabitacionDao extends CrudRepository<Habitacion, Long> {
}
