package pe.edu.uandina.hotelzSpring.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "detalleReserva")
public class DetalleReserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "ingreso")
    private Date ingreso;
    @Column(name = "salida")
    private Date salida;
    @Column(name = "precio")
    private Float precio;
    @Column(name = "adelanto")
    private Float adelanto;
    @Column(name = "dias")
    private Integer dias;

    //    pertenece a un cliente
    @OneToMany(mappedBy = "tieneDetalleReserva")
    private List<Cliente> clientes;

    //referencia de muchos a uno para tieneRestaurante
    @ManyToOne
    @JoinColumn(name = "tieneRestaurante", referencedColumnName = "id")
    private Testimonio tieneRestaurante;

    //referencia de muchos a uno para tieneHabitacion
    @ManyToOne
    @JoinColumn(name = "tieneHabitacion", referencedColumnName = "id")
    private Testimonio tieneHabitacion;

    public DetalleReserva() {
    }

    public DetalleReserva(Date ingreso, Date salida, Float precio, Float adelanto, Integer dias, List<Cliente> clientes) {
        this.ingreso = ingreso;
        this.salida = salida;
        this.precio = precio;
        this.adelanto = adelanto;
        this.dias = dias;
        this.clientes = clientes;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getIngreso() {
        return ingreso;
    }

    public void setIngreso(Date ingreso) {
        this.ingreso = ingreso;
    }

    public Date getSalida() {
        return salida;
    }

    public void setSalida(Date salida) {
        this.salida = salida;
    }

    public Float getPrecio() {
        return precio;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public Float getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(Float adelanto) {
        this.adelanto = adelanto;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
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

    public Testimonio getTieneRestaurante() {
        return tieneRestaurante;
    }

    public void setTieneRestaurante(Testimonio tieneRestaurante) {
        this.tieneRestaurante = tieneRestaurante;
    }

    public Testimonio getTieneHabitacion() {
        return tieneHabitacion;
    }

    public void setTieneHabitacion(Testimonio tieneHabitacion) {
        this.tieneHabitacion = tieneHabitacion;
    }
}
