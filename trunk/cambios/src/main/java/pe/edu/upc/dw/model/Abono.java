/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

import java.util.Date;

/**
 *
 * @author dell
 */
public class Abono {
    private Double monto;
    private Date fecha_Inicio;
    private Date fecha_fin;
    private Cliente cliente;
    private Espacio espacio;

    public Cliente getCliente() {
        return cliente;
    }

    public Espacio getEspacio() {
        return espacio;
    }

    public Date getFecha_Inicio() {
        return fecha_Inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setEspacio(Espacio espacio) {
        this.espacio = espacio;
    }

    public void setFecha_Inicio(Date fecha_Inicio) {
        this.fecha_Inicio = fecha_Inicio;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public void setMonto(Double monto) {
        this.monto = monto;
    }

    public Double getMonto() {
        return monto;
    }

    public Abono() {
    }



}
