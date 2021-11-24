package pe.edu.uandina.hotelzSpring.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import pe.edu.uandina.hotelzSpring.modelo.Cliente;
import pe.edu.uandina.hotelzSpring.modelo.services.IClienteService;

import java.util.List;

//@RestController la clase q sigue sera un controlador
@RestController

//@RequestMapping("/api") ruta donde estaran los elementos a trabajar
@RequestMapping("/api")
public class ClienteRestController {
    @Autowired
    private IClienteService clienteService;

    @GetMapping("/clientes")
    public List<Cliente> listar(){
        return clienteService.findAll();
    }

    //elemento ruta para un elemento de la base de datos
    @GetMapping("/clientes/{id}")
    public Cliente mostrar(@PathVariable Long id){
        return clienteService.findById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    private Cliente crear(@RequestBody Cliente cliente){
        return clienteService.save(cliente);
    }

    @PutMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente actualizar(@RequestBody Cliente cliente, @PathVariable Long id){
        Cliente clienteOriginal = clienteService.findById(id);
        clienteOriginal.setNombre(cliente.getNombre());
        return clienteService.save(clienteOriginal);
    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void eliminar(@PathVariable Long id){
        clienteService.delete(id);
    }

}
