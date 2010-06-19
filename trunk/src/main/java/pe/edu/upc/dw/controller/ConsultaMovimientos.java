/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import com.sun.jmx.remote.internal.ClientCommunicatorAdmin;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.ConsultaMovimiento;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author Carlos
 */
public class ConsultaMovimientos extends HttpServlet {
   
   

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       ConsultaMovimiento conmov= new ConsultaMovimiento();
       Cliente cliente=new Cliente();
       Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String s = df.format(now).toUpperCase();

       cliente.setNombre("Pedro Pablo Chavez");
       cliente.setId(Integer.parseInt(req.getParameter("idcliente")));
       Tarjeta tarjeta = new Tarjeta();
       tarjeta.setCliente(cliente);
       tarjeta.setNro_tarjeta("4213880944529066");

        Alquiler alquiler =new Alquiler();
        alquiler.setImporte(120.0);
        alquiler.setTarjeta(tarjeta);
        conmov.setFechadesde(req.getParameter("fechadesde"));
        conmov.setFechahasta(req.getParameter("fechahasta"));
        if (conmov.getFechadesde() == null){
            conmov.setFechadesde(s);
            conmov.setFechahasta(s);
        }

        req.setAttribute("conmov", conmov);        
        req.setAttribute("alquiler", alquiler);
        req.setAttribute("cliente", cliente);
        req.setAttribute("tipovisor", "C");
        req.getRequestDispatcher("card_mov.jsp").forward(req, resp);

        //super.doGet(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultaMovimiento conmov= new ConsultaMovimiento();
       Cliente cliente=new Cliente();
       cliente.setNombre("Pedro Pablo Chavez");
       Tarjeta tarjeta = new Tarjeta();
       tarjeta.setCliente(cliente);
       tarjeta.setNro_tarjeta("4213880944529066");
       req.setAttribute("tipovisor", "C");
       cliente.setId(Integer.parseInt(req.getParameter("idcliente")));

        Alquiler alquiler =new Alquiler();
        alquiler.setImporte(20.0);
        alquiler.setTarjeta(tarjeta);

        conmov.setFechadesde(req.getParameter("fechadesde"));
        conmov.setFechahasta(req.getParameter("fechahasta"));



        req.setAttribute("conmov", conmov);
        req.setAttribute("alquiler", alquiler);
        req.setAttribute("cliente", cliente);

        req.getRequestDispatcher("card_mov.jsp").forward(req, resp);

    }



}
