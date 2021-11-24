package pe.edu.uandina.hotelzSpring.modelo.services;

import pe.edu.uandina.hotelzSpring.modelo.DetalleReserva;

import java.util.List;

public interface IDetalleReservaService {

    public List<DetalleReserva> findAll();
    public  DetalleReserva findById(long id);
    public  DetalleReserva save(DetalleReserva detalleReserva);
    public  void delete(long id);
}
