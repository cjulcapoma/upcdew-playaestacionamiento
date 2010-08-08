/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.model;

/**
 *
 * @author dell
 */
public class Espacio {
    private int id;
    private int estado;
    private Local local;

    public Espacio() {
    }



    public int getEstado() {
        return estado;
    }

    public int getId() {
        return id;
    }

    public Local getLocal() {
        return local;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLocal(Local local) {
        this.local = local;
    }

    

}
