package pe.edu.uandina.hotelzSpring.modelo;

import javax.persistence.*;

//la clase que precede se convierte en una tabla para la base de datos
@Entity
//table hace referencia a la tabla y le damos nombre
@Table(name = "usuario")
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private  String password;
    @Column(name = "tarea")
    private String tarea;
    @Column(name = "estado")
    private Integer estado;

    public Usuario() {
    }

    public Usuario( String nombre, String login, String password, String tarea, Integer estado) {
        this.nombre = nombre;
        this.login = login;
        this.password = password;
        this.tarea = tarea;
        this.estado = estado;
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

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public Integer getEstado() {
        return estado;
    }

    public void setEstado(Integer estado) {
        this.estado = estado;
    }
}
