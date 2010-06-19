/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

import java.util.Date;

/**
 *
 * @author Carlos
 */
public class ConsultaMovimiento {

    private String fechadesde;
    private String fechahasta;
    private Cliente cliente;

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
