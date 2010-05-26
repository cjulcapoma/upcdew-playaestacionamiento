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

    public Double getMonto() {
        return monto;
    }



}
