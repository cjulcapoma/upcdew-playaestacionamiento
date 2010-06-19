/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.Tarjeta;

/**
 *
 * @author Carlos
 */
public class ConsultaSaldos extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente cliente = new Cliente();
        Tarjeta tarjeta = new Tarjeta();
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        String s = df.format(now).toUpperCase();

        req.setAttribute("fechaactual", s);

        req.setAttribute("tipovisor", "C");

        cliente.setNombre("Pedro Pablo Chavez");
        cliente.setId(Integer.parseInt(req.getParameter("idcliente")));
        tarjeta.setNro_tarjeta("4213880944529066");
        tarjeta.setSaldo_disponible(149.50);
        cliente.setTarjeta(tarjeta);

        req.setAttribute("cliente", cliente);
        req.getRequestDispatcher("card_account.jsp").forward(req, resp);

    }

    
   
    
}
