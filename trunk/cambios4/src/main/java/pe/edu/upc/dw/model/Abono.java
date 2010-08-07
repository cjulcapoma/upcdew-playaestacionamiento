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
    private String tipo_abono;

    public Abono(Double monto, Date fecha_inicio, Date fecha_fin, Cliente cliente,String tipo_abono, Espacio espacio) {
        this.monto= monto;
        this.fecha_Inicio = fecha_inicio;
        this.fecha_fin = fecha_fin;
        this.cliente = cliente;
        this.espacio = espacio;
        this.tipo_abono=tipo_abono;
    }

    public String getTipo_abono() {
        return tipo_abono;
    }

    public void setTipo_abono(String tipo_abono) {
        this.tipo_abono = tipo_abono;
    }

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
