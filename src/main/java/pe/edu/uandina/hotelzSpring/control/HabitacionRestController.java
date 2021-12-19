package pe.edu.uandina.hotelzSpring.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.hotelzSpring.modelo.Habitacion;
import pe.edu.uandina.hotelzSpring.modelo.services.IHabitacionService;


import java.util.List;

//@RestController la clase q sigue sera un controlador
@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class HabitacionRestController {

    @Autowired
    private IHabitacionService habitacionService;

    @GetMapping("/habitacion")
    public List<Habitacion> listar(){
        return habitacionService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/habitacion/{id}")
    public Habitacion mostrar(@PathVariable Long id){
        return habitacionService.findById(id);
    }

    @PostMapping("/habitacion")
    @ResponseStatus(HttpStatus.CREATED)
    private Habitacion crear(@RequestBody Habitacion habitacion){
        return habitacionService.save(habitacion);
    }

    @PutMapping("/habitacion/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Habitacion actualizar(@RequestBody Habitacion habitacion, @PathVariable Long id){
        Habitacion habitacionOriginal = habitacionService.findById(id);
        habitacionOriginal.setTipoHabitacion(habitacion.getTipoHabitacion());
        habitacionOriginal.setNombreHabitacion(habitacion.getNombreHabitacion());
        habitacionOriginal.setFotoHabitacion(habitacion.getFotoHabitacion());
        habitacionOriginal.setEstadoHabitacion(habitacion.getEstadoHabitacion());
        habitacionOriginal.setPrecioHabitacion(habitacion.getPrecioHabitacion());
        habitacionOriginal.setDescripcionHabitacion(habitacion.getDescripcionHabitacion());
        return habitacionService.save(habitacionOriginal);
    }


    @DeleteMapping("/habitacion/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        habitacionService.delete(id);
    }
}
