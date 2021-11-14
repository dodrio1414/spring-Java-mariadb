package pe.edu.uandina.hotelzSpring.modelo;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "testimonio")
public class Testimonio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "contenido")
    private String contenido;
    @Column(name = "estado")
    private Integer estado;

//    pertenece a un cliente
    @OneToMany(mappedBy = "tieneTestimonio")
    private List<Cliente> clientes;

    public Testimonio() {
    }

    public Testimonio(String contenido, Integer estado, List<Cliente> clientes) {
        this.contenido = contenido;
        this.estado = estado;
        this.clientes = clientes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }

    public List<Cliente> getClientes() {
        if (this.clientes == null){
            this.clientes = new ArrayList<>();
        }
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }
}
