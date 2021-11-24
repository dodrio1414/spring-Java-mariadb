package pe.edu.uandina.hotelzSpring.modelo.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.uandina.hotelzSpring.modelo.Habitacion;
import pe.edu.uandina.hotelzSpring.modelo.dao.IHabitacionDao;
import java.util.List;

@Service
public class HabitacionServiceImplement implements IHabitacionService{

    @Autowired
    private IHabitacionDao habitacionDao;

    @Override
    //@Transactional hace un control de una transaccion
    @Transactional(readOnly = true)
    public List<Habitacion> findAll() {
        return (List<Habitacion>) habitacionDao.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Habitacion findById(long id) {

        return habitacionDao.findById(id).orElse(null);
    }

    @Override
    @Transactional
    public Habitacion save(Habitacion habitacion) {
        return habitacionDao.save(habitacion);
    }

    @Override
    @Transactional
    public void delete(long id) {
        habitacionDao.deleteById(id);
    }


}
