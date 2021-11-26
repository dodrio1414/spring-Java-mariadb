package pe.edu.uandina.hotelzSpring.modelo;


import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "habitacion")
public class Habitacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "nombreHabitacion")
    private String nombreHabitacion;

    @Column(name = "fotoHabitacion")
    private String fotoHabitacion;

    @Column(name = "estadoHabitacion")
    private String estadoHabitacion;
    @Column(name = "tipoHabitacion")
    private String tipoHabitacion;
    @Column(name = "precioHabitacion", scale = 2)
    private BigDecimal precioHabitacion;
    @Column(name = "descripcionHabitacion")
    private String descripcionHabitacion;


    //lista de detalle de reservas
    @OneToMany(mappedBy = "tieneDetalleReservaHab")
    //@JsonManagedReference
    @JsonManagedReference(value = "tieneDetalleReservaHab")

    //@JsonIdentityReference(alwaysAsId = true)
    private List<DetalleReserva> tieneDetalleReservaHab;

    public Habitacion() {
    }

    public Habitacion(long id, String nombreHabitacion, String fotoHabitacion, String estadoHabitacion, String tipoHabitacion, BigDecimal precioHabitacion, String descripcionHabitacion, List<DetalleReserva> tieneDetalleReservaHab) {
        this.id = id;
        this.nombreHabitacion = nombreHabitacion;
        this.fotoHabitacion = fotoHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.descripcionHabitacion = descripcionHabitacion;
        this.tieneDetalleReservaHab = tieneDetalleReservaHab;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombreHabitacion() {
        return nombreHabitacion;
    }

    public void setNombreHabitacion(String nombreHabitacion) {
        this.nombreHabitacion = nombreHabitacion;
    }

    public String getFotoHabitacion() {
        return fotoHabitacion;
    }

    public void setFotoHabitacion(String fotoHabitacion) {
        this.fotoHabitacion = fotoHabitacion;
    }

    public String getEstadoHabitacion() {
        return estadoHabitacion;
    }

    public void setEstadoHabitacion(String estadoHabitacion) {
        this.estadoHabitacion = estadoHabitacion;
    }

    public String getTipoHabitacion() {
        return tipoHabitacion;
    }

    public void setTipoHabitacion(String tipoHabitacion) {
        this.tipoHabitacion = tipoHabitacion;
    }

    public BigDecimal getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(BigDecimal precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }

    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }

    public List<DetalleReserva> getTieneDetalleReservaHab() {
        if (this.tieneDetalleReservaHab == null){
            this.tieneDetalleReservaHab = new ArrayList<>();
        }
        return tieneDetalleReservaHab;
    }

    public void setTieneDetalleReservaHab(List<DetalleReserva> tieneDetalleReservaHab) {
        this.tieneDetalleReservaHab = tieneDetalleReservaHab;
    }
}
