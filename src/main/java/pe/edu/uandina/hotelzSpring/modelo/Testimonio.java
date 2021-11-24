package pe.edu.uandina.hotelzSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToOne
    @JoinColumn(name = "tieneTestimonio", referencedColumnName = "id")
    @JsonBackReference
    private Cliente tieneTestimonio;


    public Testimonio() {
    }

    public Testimonio(String contenido, Integer estado) {
        this.contenido = contenido;
        this.estado = estado;
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

    public Cliente getTieneTestimonio() {
        return tieneTestimonio;
    }

    public void setTieneTestimonio(Cliente tieneTestimonio) {
        this.tieneTestimonio = tieneTestimonio;
    }
}
