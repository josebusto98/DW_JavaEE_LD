package model;

import java.util.Date;

/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Solicitud.
 *
 */
public class Solicitud {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Solicitud en la base de datos    
     */
    private int id;
    private Date fecha;
    private String nombre;
    private String email;
    private String telefono;
    private String direccion;
    /*
   Variable de tipo Coche que se ha solicituado en la peticion de reserva.
     */
    private Coche srv;

    public Solicitud(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Coche getCoche() {
        return srv;
    }

    public void setCoche(Coche srv) {
        this.srv = srv;
    }

    @Override
    public String toString() {
        return "Solicitud{" + "id=" + id + ", fecha=" + fecha + ", nombre=" + nombre + ", email=" + email + ", telefono=" + telefono + ", direccion=" + direccion+ ", coche=" + srv + '}';
    }

}
