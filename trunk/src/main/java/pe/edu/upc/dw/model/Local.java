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

    
}
