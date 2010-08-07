/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

import java.util.List;

/**
 *
 * @author dell
 */
public class Local {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String cant_espacios;
    private String tolerancia;
    private String precio_hora;
    private String porc_dscto_tarjeta;
    private int cant_esp_disponibles;
    private List<Espacio> espacio;
    private List<Alquiler> alquiler;

    public Local() {
    }

    

    public Local(int id, String nombre, String direccion, String telefono, String cant_espacios) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cant_espacios = cant_espacios;
    }

    public List<Alquiler> getAlquiler() {
        return alquiler;
    }

    public int getCant_esp_disponibles() {
        return cant_esp_disponibles;
    }

    public String getCant_espacios() {
        return cant_espacios;
    }

    public String getDireccion() {
        return direccion;
    }

    public List<Espacio> getEspacio() {
        return espacio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPorc_dscto_tarjeta() {
        return porc_dscto_tarjeta;
    }

    public String getPrecio_hora() {
        return precio_hora;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTolerancia() {
        return tolerancia;
    }

    public void setAlquiler(List<Alquiler> alquiler) {
        this.alquiler = alquiler;
    }

    public void setCant_esp_disponibles(int cant_esp_disponibles) {
        this.cant_esp_disponibles = cant_esp_disponibles;
    }

    public void setCant_espacios(String cant_espacios) {
        this.cant_espacios = cant_espacios;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEspacio(List<Espacio> espacio) {
        this.espacio = espacio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPorc_dscto_tarjeta(String porc_dscto_tarjeta) {
        this.porc_dscto_tarjeta = porc_dscto_tarjeta;
    }

    public void setPrecio_hora(String precio_hora) {
        this.precio_hora = precio_hora;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTolerancia(String tolerancia) {
        this.tolerancia = tolerancia;
    }

    
}
