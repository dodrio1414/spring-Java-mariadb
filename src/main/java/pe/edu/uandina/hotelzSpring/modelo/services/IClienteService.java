package pe.edu.uandina.hotelzSpring.modelo.services;

import pe.edu.uandina.hotelzSpring.modelo.Cliente;

import java.util.List;

//interface del servicio

//IclienteService se encarga de definir los metodos a implmetar y la salida de los datos
public interface IClienteService {

    public List<Cliente> findAll();
    public  Cliente findById(long id);
    public  Cliente save(Cliente cliente);
    public  void delete(long id);
}
