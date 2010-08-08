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
public class Tarjeta {
    private int id;
    private String nro_tarjeta;
    private String estado;
    private Double saldo_disponible;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Tarjeta() {
    }



    public Cliente getCliente() {
        return cliente;
    }

    public String getEstado() {
        return estado;
    }

    public String getNro_tarjeta() {
        return nro_tarjeta;
    }

    public Double getSaldo_disponible() {
        return saldo_disponible;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setNro_tarjeta(String nro_tarjeta) {
        this.nro_tarjeta = nro_tarjeta;
    }

    public void setSaldo_disponible(Double saldo_disponible) {
        this.saldo_disponible = saldo_disponible;
    }
    




}
