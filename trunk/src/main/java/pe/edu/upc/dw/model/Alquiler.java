/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

import java.sql.Time;
import java.util.Date;

/**
 *
 * @author dell
 */
public class Alquiler {
    private Date fecha;
    private Time hora_inicio;
    private Time hora_fin;
    private Double importe;
    private String placa;
    private Tarjeta tarjeta;
    private Local local;

    public Date getFecha() {
        return fecha;
    }

    public Time getHora_fin() {
        return hora_fin;
    }

    public Time getHora_inicio() {
        return hora_inicio;
    }

    public Double getImporte() {
        return importe;
    }

    public Local getLocal() {
        return local;
    }

    public String getPlaca() {
        return placa;
    }

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    


}
