/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

/**
 *
 * @author Carlos
 */
public class ConsultaIngresoSalidas {
    private String fechadesde;
    private String fechahasta;
    private String id_local;
    private String id_cliente;
    private String placa;

    public String getFechadesde() {
        return fechadesde;
    }

    public String getFechahasta() {
        return fechahasta;
    }

    public String getId_cliente() {
        return id_cliente;
    }

    public String getId_local() {
        return id_local;
    }

    public String getPlaca() {
        return placa;
    }

    public void setFechadesde(String fechadesde) {
        this.fechadesde = fechadesde;
    }

    public void setFechahasta(String fechahasta) {
        this.fechahasta = fechahasta;
    }

    public void setId_cliente(String id_cliente) {
        this.id_cliente = id_cliente;
    }

    public void setId_local(String id_local) {
        this.id_local = id_local;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }


}
