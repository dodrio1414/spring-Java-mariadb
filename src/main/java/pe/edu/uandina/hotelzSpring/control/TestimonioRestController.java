package pe.edu.uandina.hotelzSpring.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.hotelzSpring.modelo.Testimonio;
import pe.edu.uandina.hotelzSpring.modelo.services.ITestimonioService;

import java.util.List;

//@RestController la clase q sigue sera un controlador
@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class TestimonioRestController {

    @Autowired
    private ITestimonioService testimonioService;

    @GetMapping("/testimonio")
    public List<Testimonio> listar(){
        return testimonioService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/testimonio/{id}")
    public Testimonio mostrar(@PathVariable Long id){
        return testimonioService.findById(id);
    }

    @PostMapping("/testimonio")
    @ResponseStatus(HttpStatus.CREATED)
    private Testimonio crear(@RequestBody Testimonio testimonio){
        return testimonioService.save(testimonio);
    }

    @PutMapping("/testimonio/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Testimonio actualizar(@RequestBody Testimonio testimonio, @PathVariable Long id){
        Testimonio testimonioOriginal = testimonioService.findById(id);
        testimonioOriginal.setContenido(testimonio.getContenido());
        return testimonioService.save(testimonioOriginal);
    }

    @DeleteMapping("/testimonio/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        testimonioService.delete(id);
    }

}
