package pe.edu.uandina.hotelzSpring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.hotelzSpring.modelo.Restaurante;
import pe.edu.uandina.hotelzSpring.modelo.services.IRestauranteService;


import java.util.List;

//@RestController la clase q sigue sera un controlador
@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class RestauranteRestController {

    @Autowired
    private IRestauranteService restauranteService;

    @GetMapping("/restaurante")
    public List<Restaurante> listar(){
        return restauranteService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/restaurante/{id}")
    public Restaurante mostrar(@PathVariable Long id){
        return restauranteService.findById(id);
    }

    @PostMapping("/restaurante")
    @ResponseStatus(HttpStatus.CREATED)
    private Restaurante crear(@RequestBody Restaurante restaurante){
        return restauranteService.save(restaurante);
    }

    @PutMapping("/restaurante/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Restaurante actualizar(@RequestBody Restaurante restaurante, @PathVariable Long id){
        Restaurante restauranteOriginal = restauranteService.findById(id);
        restauranteOriginal.setNombrePlato(restaurante.getNombrePlato());
        return restauranteService.save(restauranteOriginal);
    }


    @DeleteMapping("/restaurante/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        restauranteService.delete(id);
    }

}
