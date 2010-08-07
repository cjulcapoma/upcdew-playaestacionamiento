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

    private int id;
    private String fecha;
    private String hora_inicio;
    private String hora_fin;
    private Double importe;
    private String placa;
    private Tarjeta tarjeta;
    private Local local;
    private String estado;

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getFecha() {
        return fecha;
    }

    public Alquiler() {
    }



    public Alquiler(int nId, String fecha, String hora_inicio, String hora_fin, Double importe, String placa, Tarjeta tarjeta, Local local, String estado) {
        this.id= nId;
        this.fecha = fecha;
        this.hora_inicio = hora_inicio;
        this.hora_fin = hora_fin;
        this.importe = importe;
        this.placa = placa;
        this.tarjeta = tarjeta;
        this.local = local;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int nId) {
        this.id = nId;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public void setHora_fin(String hora_fin) {
        this.hora_fin = hora_fin;
    }

    public void setHora_inicio(String hora_inicio) {
        this.hora_inicio = hora_inicio;
    }

    public void setImporte(Double importe) {
        this.importe = importe;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public String getHora_fin() {
        return hora_fin;
    }

    public String getHora_inicio() {
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

    public Alquiler RegistrarAlquiler(Alquiler oAlquiler) {
        return oAlquiler;
    }
}
