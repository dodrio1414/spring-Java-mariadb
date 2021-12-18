package pe.edu.uandina.hotelzSpring.control;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import pe.edu.uandina.hotelzSpring.modelo.DetalleReserva;

import pe.edu.uandina.hotelzSpring.modelo.services.IDetalleReservaService;

import java.time.LocalDate;
import java.util.List;

@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class DetalleReservaRestController {

    @Autowired
    private IDetalleReservaService detalleReservaService;

    @GetMapping("/detallaReserva")
    public List<DetalleReserva> listar(){
        return detalleReservaService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/detallaReserva/{id}")
    public DetalleReserva mostrar(@PathVariable Long id){
        return detalleReservaService.findById(id);
    }

    @PostMapping("/detallaReserva")
    @ResponseStatus(HttpStatus.CREATED)
    private DetalleReserva crear(@RequestBody DetalleReserva detalleReserva){
        detalleReserva.setIngreso(LocalDate.now());
        //detalleReserva.setDias(LocalDate.now());
        return detalleReservaService.save(detalleReserva);
    }

    @PutMapping("/detallaReserva/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public DetalleReserva actualizar(@RequestBody DetalleReserva detalleReserva, @PathVariable Long id){
        DetalleReserva detalleOriginal = detalleReservaService.findById(id);
        detalleOriginal.setPrecio(detalleReserva.getPrecio());
        detalleOriginal.setIngreso(detalleReserva.getIngreso());
        detalleOriginal.setSalida(detalleReserva.getSalida());
        detalleOriginal.setAdelanto(detalleReserva.getAdelanto());
        detalleOriginal.setDias(detalleReserva.getDias());
        return detalleReservaService.save(detalleOriginal);
    }


    @DeleteMapping("/detallaReserva/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        detalleReservaService.delete(id);
    }

}
