package pe.edu.uandina.hotelzSpring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.hotelzSpring.modelo.Usuario;

public interface IUsuarioDao extends CrudRepository<Usuario, Long> {
}
