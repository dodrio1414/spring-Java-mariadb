package pe.edu.uandina.hotelzSpring.modelo;


import javax.persistence.*;
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
    @Column(name = "estadoHabitacion")
    private String estadoHabitacion;
    @Column(name = "tipoHabitacion")
    private String tipoHabitacion;
    @Column(name = "precioHabitacion")
    private Float precioHabitacion;
    @Column(name = "descripcionHabitacion")
    private String descripcionHabitacion;

    //    pertenece a un detalleReserva
    @OneToMany(mappedBy = "tieneHabitacion")
    private List<DetalleReserva> detalleReservas;

    public Habitacion() {
    }

    public Habitacion(String nombreHabitacion, String estadoHabitacion, String tipoHabitacion, Float precioHabitacion, String descripcionHabitacion, List<DetalleReserva> detalleReservas) {
        this.nombreHabitacion = nombreHabitacion;
        this.estadoHabitacion = estadoHabitacion;
        this.tipoHabitacion = tipoHabitacion;
        this.precioHabitacion = precioHabitacion;
        this.descripcionHabitacion = descripcionHabitacion;
        this.detalleReservas = detalleReservas;
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

    public Float getPrecioHabitacion() {
        return precioHabitacion;
    }

    public void setPrecioHabitacion(Float precioHabitacion) {
        this.precioHabitacion = precioHabitacion;
    }

    public String getDescripcionHabitacion() {
        return descripcionHabitacion;
    }

    public void setDescripcionHabitacion(String descripcionHabitacion) {
        this.descripcionHabitacion = descripcionHabitacion;
    }

    public List<DetalleReserva> getDetalleReservas() {
        if (this.detalleReservas == null){
            this.detalleReservas = new ArrayList<>();
        }
        return detalleReservas;
    }

    public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
        this.detalleReservas = detalleReservas;
    }

}
