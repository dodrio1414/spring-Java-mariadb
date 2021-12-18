package pe.edu.uandina.hotelzSpring.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.hotelzSpring.modelo.Usuario;
import pe.edu.uandina.hotelzSpring.modelo.services.IUsuarioService;

import java.util.List;

//@RestController la clase q sigue sera un controlador
@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class UsuarioRestController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping("/usuarios")
    public List<Usuario> listar(){
        return usuarioService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/usuarios/{id}")
    public Usuario mostrar(@PathVariable Long id){
        return usuarioService.findById(id);
    }

    @PostMapping("/usuarios")
    @ResponseStatus(HttpStatus.CREATED)
    private Usuario crear(@RequestBody Usuario usuario){
        return usuarioService.save(usuario);
    }

    @PutMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Usuario actualizar(@RequestBody Usuario usuario, @PathVariable Long id){
        Usuario usuarioOriginal = usuarioService.findById(id);
        usuarioOriginal.setNombre(usuario.getNombre());
        usuarioOriginal.setLogin(usuario.getLogin());
        usuarioOriginal.setEstado(usuario.getEstado());
        usuarioOriginal.setTarea(usuario.getTarea());
        usuarioOriginal.setPassword(usuario.getPassword());
        return usuarioService.save(usuarioOriginal);
    }

    @DeleteMapping("/usuarios/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        usuarioService.delete(id);
    }

}
