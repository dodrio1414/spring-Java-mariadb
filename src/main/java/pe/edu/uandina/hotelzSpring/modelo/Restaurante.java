package pe.edu.uandina.hotelzSpring.modelo;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.math.BigDecimal;
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
    @Column(name = "precioPlato", scale = 2)
    private BigDecimal precioPlato;

    @Column(name = "fotoRestaurante")
    private String fotoRestaurante;


    //    pertenece a un detalleReserva
    @OneToMany(mappedBy = "tieneDetalleReservaRest")
    @JsonManagedReference
    private List<DetalleReserva> tieneDetalleReservaRest;

    public Restaurante() {
    }

    public Restaurante(String nombrePlato, BigDecimal precioPlato, String fotoRestaurante) {
        this.nombrePlato = nombrePlato;
        this.precioPlato = precioPlato;
        this.fotoRestaurante = fotoRestaurante;
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

    public BigDecimal getPrecioPlato() {
        return precioPlato;
    }

    public void setPrecioPlato(BigDecimal precioPlato) {
        this.precioPlato = precioPlato;
    }

    public String getFotoRestaurante() {
        return fotoRestaurante;
    }

    public void setFotoRestaurante(String fotoRestaurante) {
        this.fotoRestaurante = fotoRestaurante;
    }

    public List<DetalleReserva> getDetalleReservas() {
        if (this.tieneDetalleReservaRest == null){
            this.tieneDetalleReservaRest = new ArrayList<>();
        }
        return tieneDetalleReservaRest;
    }

    public void setDetalleReservas(List<DetalleReserva> detalleReservas) {
        this.tieneDetalleReservaRest = detalleReservas;
    }
}
