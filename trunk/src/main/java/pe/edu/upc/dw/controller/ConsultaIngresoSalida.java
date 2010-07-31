/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.ConsultaIngresoSalidas;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Usuario;

/**
 *
 * @author Carlos
 */
public class ConsultaIngresoSalida extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ConsultaIngresoSalidas coningsal= new ConsultaIngresoSalidas();
        
        
        HttpSession session = req.getSession();
        Usuario cliente  = (Usuario)session.getAttribute("usuario");

        Local local=new Local(1, "San Isidro", "Av. Canaval y Moreyra 354", "234232", "50");
        //Date now = new Date();
        String now = "20/02/2010";

        req.setAttribute("tipovisor", "A");
        req.setAttribute("cliente", cliente);
        
        
        String tipoconsulta=req.getParameter("querytype");
        coningsal.setFechadesde(req.getParameter("fechadesde"));
        coningsal.setFechahasta(req.getParameter("fechahasta"));        
        coningsal.getAlquileres().add(new Alquiler(1,now,"12:49","13:49",12.00,"XBO2323",null,local,null));
        coningsal.getAlquileres().add(new Alquiler(2,now,"12:49","13:49",12.00,"HH575",null,local,null));
        coningsal.getAlquileres().add(new Alquiler(3,now,"12:49","13:49",12.00,"HJ7876",null,local,null));
        
        if (tipoconsulta.equals("A")){
        coningsal.getAlquileres().add(new Alquiler(4,now,"12:49","13:49",12.00,"FTRT565",null,local,null));
        coningsal.getAlquileres().add(new Alquiler(5,now,"12:49","13:49",12.00,"GTG555",null,local,null));
        coningsal.getAlquileres().add(new Alquiler(6,now,"12:49","13:49",12.00,"HGY675",null,local,null));
        }
        if (tipoconsulta.equals("L")){
        coningsal.getAlquileres().add(new Alquiler(7,now,"12:49","13:49",12.00,"DC343",null,local,null));
        
        }
        
        req.setAttribute("coningsal", coningsal);
        req.setAttribute("querytype", tipoconsulta);

       
        req.getRequestDispatcher("query.jsp").forward(req, resp);
        

    }
   
    
}
