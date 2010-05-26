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
    private String nro_tarjeta;
    private String estado;
    private Double saldo_disponible;
    private Cliente cliente;
    private List<Alquiler> alquiler;

    public List<Alquiler> getAlquiler() {
        return alquiler;
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




}
