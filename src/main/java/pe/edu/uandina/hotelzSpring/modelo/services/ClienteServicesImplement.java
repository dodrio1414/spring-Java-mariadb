package pe.edu.uandina.hotelzSpring.modelo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.Cliente;
import pe.edu.uandina.hotelzSpring.modelo.dao.IClienteDao;
import java.util.List;

//@Service convierte a la implentacion siguiente en un servicio
@Service
//implementacion de la clases servicesImplements que implementa a la interfaz IclienteService
//ClienteServiceImplements implentar y construir los metodos
public class ClienteServicesImplement implements IClienteService{

    //para acceder al Dao necesito @Autowired que genere una instancia en automatico en este caso a ICLienteDao y por consiguiente a la DB
    @Autowired
    private IClienteDao clienteDao;


    //para hacer uso de los metodos tenemos q usar la instancia nueva de CRUD
    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<Cliente> findAll() {
        return (List<Cliente>) clienteDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Cliente findById(long id) {

        return clienteDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Cliente save(Cliente cliente) {
        return clienteDao.save(cliente);
    }

    @Override
    @Transactional
    public void delete(long id) {
        clienteDao.deleteById(id);
    }
}
