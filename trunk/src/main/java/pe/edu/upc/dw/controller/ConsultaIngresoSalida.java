/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dw.model.ConsultaIngresoSalidas;

/**
 *
 * @author Carlos
 */
public class ConsultaIngresoSalida extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultaIngresoSalidas coningsal= new ConsultaIngresoSalidas();

        coningsal.setFechadesde (req.getParameter("fechadesde"));
        coningsal.setFechahasta(req.getParameter("fechahasta"));
        coningsal.setPlaca(req.getParameter("placa"));
        coningsal.setId_cliente(req.getParameter("id_cliente"));
        coningsal.setId_local(req.getParameter("id_local"));
        
        String tipoconsulta=req.getParameter("tipoconsulta");

        req.setAttribute("coningsal", coningsal);
        
        if (tipoconsulta.equals("placa") ){
            req.getRequestDispatcher("query_placa.jsp").forward(req, resp);
        }
        if (tipoconsulta.equals("cliente")){
            req.getRequestDispatcher("query_abon.jsp").forward(req, resp);
        }
        if (tipoconsulta.equals("local")){
            req.getRequestDispatcher("query.jsp").forward(req, resp);
        }

    }
   
    
}
