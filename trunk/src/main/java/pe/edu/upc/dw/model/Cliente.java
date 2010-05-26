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
public class Cliente {
    private int id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;

    public List<Abono> getAbono() {
        return abono;
    }

    public String getCorreo() {
        return correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getTipo_cliente() {
        return tipo_cliente;
    }
    private String tipo_cliente;
    private Tarjeta tarjeta;
    private List<Abono> abono;


}
