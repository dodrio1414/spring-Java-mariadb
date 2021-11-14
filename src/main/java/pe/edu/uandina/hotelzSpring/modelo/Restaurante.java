package pe.edu.uandina.hotelzSpring.modelo;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Restaurante")
public class Restaurante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "nombrePlato")
    private String nombrePlato;
    @Column(name = "precioPlato")
    private Float precioPlato;

    //    pertenece a un detalleReserva
    @OneToMany(mappedBy = "tieneRestaurante")
    private List<DetalleReserva> detalleReservas;

    public Restaurante() {
    }

    public Restaurante(String nombrePlato, Float precioPlato, List<DetalleReserva> detalleReservas) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.detalleReservas = detalleReservas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombrePlato() {
        return nombrePlato;
    }

    public void setNombrePlato(String nombrePlato) {
        this.nombrePlato = nombrePlato;
    }

    public Float getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(Float precioPlato) {
        this.precioPlato = precioPlato;
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
