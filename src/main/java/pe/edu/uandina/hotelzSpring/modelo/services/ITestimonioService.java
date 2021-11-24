package pe.edu.uandina.hotelzSpring.modelo.services;

import pe.edu.uandina.hotelzSpring.modelo.Testimonio;

import java.util.List;

public interface ITestimonioService {
    public List<Testimonio> findAll();
    public  Testimonio findById(long id);
    public  Testimonio save(Testimonio testimonio);
    public  void delete(long id);
}
