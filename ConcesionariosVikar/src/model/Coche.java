package model;

import java.util.Date;
/**
 * Clase tipo "Modelo" que representa una entidad (registro) de la tabla de
 * Servidor.
 *
 */
public class Coche {

    /*
    Variables de Instancia de la clase.Cada variable, mapea a un campo de la tabla de 
    Servidor en la base de datos    
     */
    private int id;
    private Date fechaPublicacion;
    private String marca;
    private String modelo;
    private String color;
    private String precio;

    public Coche(int id) {
        // La fecha de publicacion es la fecha del servidor
        this.fechaPublicacion = new Date();
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
    
    public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getPrecio() {
		return precio;
	}

	public void setPrecio(String precio) {
		this.precio = precio;
	}

	@Override
    public String toString() {
        return "Coche{" + "id=" + id + ", fechaPublicacion=" + fechaPublicacion + ", marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", precio=" +precio + '}';
    }

}
