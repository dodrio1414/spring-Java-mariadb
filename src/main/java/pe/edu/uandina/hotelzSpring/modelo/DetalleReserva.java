package pe.edu.uandina.hotelzSpring.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
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
    private LocalDate ingreso;
    @Column(name = "salida")
    private LocalDate salida;
    @Column(name = "precio", scale = 2)
    private BigDecimal precio;
    @Column(name = "adelanto", scale = 2)
    private BigDecimal adelanto;
    @Column(name = "dias")
    private Integer dias;


    // cliente
    @ManyToOne
    @JoinColumn(name = "tieneDetalleReserva", referencedColumnName = "id")
    @JsonBackReference
    //@JsonBackReference
    private Cliente tieneDetalleReserva;

    //referencia de muchos a uno para tieneRestaurante
    @ManyToOne
    @JoinColumn(name = "tieneDetalleReservaRest", referencedColumnName = "id")
    @JsonBackReference
    //@JsonBackReference
    private Restaurante tieneDetalleReservaRest;


    //referencia de muchos a uno para tieneHabitacion
    @ManyToOne
    @JoinColumn(name = "tieneDetalleReservaHab", referencedColumnName = "id")
    @JsonBackReference
    //@JsonBackReference
    private Habitacion tieneDetalleReservaHab;


    public DetalleReserva() {
    }

    public DetalleReserva(LocalDate ingreso, LocalDate salida, BigDecimal precio, BigDecimal adelanto, Integer dias) {
        this.ingreso = ingreso;
        this.salida = salida;
        this.precio = precio;
        this.adelanto = adelanto;
        this.dias = dias;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getIngreso() {
        return ingreso;
    }

    public void setIngreso(LocalDate ingreso) {
        this.ingreso = ingreso;
    }

    public LocalDate getSalida() {
        return salida;
    }

    public void setSalida(LocalDate salida) {
        this.salida = salida;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

    public BigDecimal getAdelanto() {
        return adelanto;
    }

    public void setAdelanto(BigDecimal adelanto) {
        this.adelanto = adelanto;
    }

    public Integer getDias() {
        return dias;
    }

    public void setDias(Integer dias) {
        this.dias = dias;
    }

    public Cliente getTieneDetalleReserva() {
        return tieneDetalleReserva;
    }

    public void setTieneDetalleReserva(Cliente tieneDetalleReserva) {
        this.tieneDetalleReserva = tieneDetalleReserva;
    }

    public Restaurante getTieneDetalleReservaRest() {
        return tieneDetalleReservaRest;
    }

    public void setTieneDetalleReservaRest(Restaurante tieneDetalleReservaRest) {
        this.tieneDetalleReservaRest = tieneDetalleReservaRest;
    }

    public Habitacion getTieneDetalleReservaHab() {
        return tieneDetalleReservaHab;
    }

    public void setTieneDetalleReservaHab(Habitacion tieneDetalleReservaHab) {
        this.tieneDetalleReservaHab = tieneDetalleReservaHab;
    }
}
