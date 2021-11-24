package pe.edu.uandina.hotelzSpring.modelo.services;

import pe.edu.uandina.hotelzSpring.modelo.Habitacion;

import java.util.List;

public interface IHabitacionService {

    public List<Habitacion> findAll();
    public  Habitacion findById(long id);
    public  Habitacion save(Habitacion habitacion);
    public  void delete(long id);
}
