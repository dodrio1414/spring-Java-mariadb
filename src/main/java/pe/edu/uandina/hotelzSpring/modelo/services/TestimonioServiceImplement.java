package pe.edu.uandina.hotelzSpring.modelo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.Cliente;
import pe.edu.uandina.hotelzSpring.modelo.Testimonio;
import pe.edu.uandina.hotelzSpring.modelo.dao.IClienteDao;
import pe.edu.uandina.hotelzSpring.modelo.dao.ITestimonioDao;

import java.util.List;

@Service
public class TestimonioServiceImplement implements ITestimonioService{

    //para acceder al Dao necesito @Autowired que genere una instancia en automatico en este caso a ICLienteDao y por consiguiente a la DB
    @Autowired
    private ITestimonioDao testimonioDao;


    //para hacer uso de los metodos tenemos q usar la instancia nueva de CRUD
    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<Testimonio> findAll() {
        return (List<Testimonio>) testimonioDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Testimonio findById(long id) {

        return testimonioDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Testimonio save(Testimonio testimonio) {
        return testimonioDao.save(testimonio);
    }

    @Override
    @Transactional
    public void delete(long id) {
        testimonioDao.deleteById(id);
    }
}
