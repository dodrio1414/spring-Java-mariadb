package pe.edu.uandina.hotelzSpring.modelo;
import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.util.ArrayList;
import javax.persistence.*;
import java.awt.*;
import java.util.List;

@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "nombre")
    private String nombre;

    @Column(name = "foto")
    private String foto;
    @Column(name = "modo")
    private String modo;
    @Column(name = "telefono")
    private String telefono;
    @Column(name = "email")
    private String email;
    @Column(name = "pais")
    private String pais;
    @Column(name = "dni")
    private String dni;

    @OneToMany(mappedBy = "tieneTestimonio")

    @JsonManagedReference(value = "tieneTestimonio")
    private List<Testimonio> testimonios;

    @OneToMany(mappedBy = "tieneDetalleReserva")

    @JsonManagedReference(value = "tieneDetalleReserva")
    private List<DetalleReserva> detalleReservas;

    public Cliente() {
    }

    public Cliente(String nombre, String foto, String modo, String telefono, String email, String pais, String dni, List<Testimonio> testimonios, List<DetalleReserva> detalleReservas) {
        this.nombre = nombre;
        this.foto = foto;
        this.modo = modo;
        this.telefono = telefono;
        this.email = email;
        this.pais = pais;
        this.dni = dni;
        this.testimonios = testimonios;
        this.detalleReservas = detalleReservas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public String getModo() {
        return modo;
    }

    public void setModo(String modo) {
        this.modo = modo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public List<Testimonio> getTestimonios() {
        if (this.testimonios == null){
            this.testimonios = new ArrayList<>();
        }
        return testimonios;
    }

    public void setTestimonios(List<Testimonio> testimonios) {
        this.testimonios = testimonios;
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
