/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

import pe.edu.upc.dw.model.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class ConsultaMovimiento {

    private String fechadesde;
    private String fechahasta;
    private Cliente cliente;
    private Tarjeta tarjeta;

    private List<Alquiler> alquileres;
    private List<Abono> abonos;

    public Tarjeta getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(Tarjeta tarjeta) {
        this.tarjeta = tarjeta;
    }

    public ConsultaMovimiento(){
        alquileres = new ArrayList<Alquiler>();
        abonos = new ArrayList<Abono>();
    }

    public List<Abono> getAbonos() {
        return abonos;
    }

    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFechadesde(String fechadesde) {
        this.fechadesde = fechadesde;
    }

    public void setFechahasta(String fechahasta) {
        this.fechahasta = fechahasta;
    }

    public String getFechadesde() {
        return fechadesde;
    }

    public String getFechahasta() {
        return fechahasta;
    }

}
