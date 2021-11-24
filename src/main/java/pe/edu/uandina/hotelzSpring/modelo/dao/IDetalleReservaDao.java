package pe.edu.uandina.hotelzSpring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.hotelzSpring.modelo.DetalleReserva;

public interface IDetalleReservaDao extends CrudRepository<DetalleReserva, Long> {
}
