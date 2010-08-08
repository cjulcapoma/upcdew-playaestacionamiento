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
    private String dni;
    private String nombre;
    private String direccion;
    private String telefono;
    private String correo;
    private String clave;
    private String estado;
    private String tipoCliente;



    public Cliente() {
    }


public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getClave() {
        return clave;
    }


    public void setAbono(List<Abono> abono) {
        this.abono = abono;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setTipo_cliente(String tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }



}
