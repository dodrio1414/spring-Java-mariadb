package pe.edu.uandina.hotelzSpring.modelo.services;

import pe.edu.uandina.hotelzSpring.modelo.Usuario;

import java.util.List;

public interface IUsuarioService {
    public List<Usuario> findAll();
    public  Usuario findById(long id);
    public  Usuario save(Usuario usuario);
    public  void delete(long id);
}
