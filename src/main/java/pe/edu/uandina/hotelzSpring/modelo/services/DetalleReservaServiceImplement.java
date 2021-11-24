package pe.edu.uandina.hotelzSpring.modelo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.DetalleReserva;
import pe.edu.uandina.hotelzSpring.modelo.dao.IDetalleReservaDao;
import java.util.List;

@Service
public class DetalleReservaServiceImplement implements IDetalleReservaService{

    @Autowired
    private IDetalleReservaDao detalleReservaDao;

    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<DetalleReserva> findAll() {
        return (List<DetalleReserva>) detalleReservaDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public DetalleReserva findById(long id) {

        return detalleReservaDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public DetalleReserva save(DetalleReserva detalleReserva) {
        return detalleReservaDao.save(detalleReserva);
    }

    @Override
    @Transactional
    public void delete(long id) {
        detalleReservaDao.deleteById(id);
    }


}
