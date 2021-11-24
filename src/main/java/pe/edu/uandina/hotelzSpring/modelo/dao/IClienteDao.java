package pe.edu.uandina.hotelzSpring.modelo.dao;

import org.springframework.data.repository.CrudRepository;
import pe.edu.uandina.hotelzSpring.modelo.Cliente;


//decompilacion de CrudRepository = ctrl+b para ver  los metodos que tiene (saveAll, findById, findALl, etc)
// dentro de ellas el tipo del id por eso trabajamos con Long
//Rol es un object  -- DAO data access object
public interface IClienteDao extends CrudRepository<Cliente, Long> {

}
