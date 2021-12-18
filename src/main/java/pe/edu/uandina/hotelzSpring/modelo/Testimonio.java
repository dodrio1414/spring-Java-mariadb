package pe.edu.uandina.hotelzSpring.modelo;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,
//        property = "id")
//@JsonIdentityReference(alwaysAsId = true)

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
    @JsonBackReference(value = "tieneTestimonio")

    //serializar Object por su id en lugar de como POJO "una instancia de una clase que no extiende ni implementa nada en especial"
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
