/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Usuario;

/**
 *
 * @author oalvarez
 */
public class SalidaPark extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //super.doPost(req, resp);
        Date now = new Date();
        DateFormat df = DateFormat.getDateInstance();
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");
        SimpleDateFormat formatoHora = new SimpleDateFormat("HH:mm");

        String sFecha = formatoFecha.format(now);
        String sHora = formatoHora.format(now);
        String sPlaca = req.getParameter("txtPlaca");

        HttpSession session = req.getSession();
        Usuario oUsuario = (Usuario)session.getAttribute("usuario");
        Alquiler oAlquiler = (Alquiler)session.getAttribute("Alquiler");

        oAlquiler.setHora_fin(sHora);
        oAlquiler.setImporte(12.00);
        oAlquiler.setEstado("02");

        session.setAttribute("alquilerB", oAlquiler);
        //req.setAttribute("Alquiler", oAlquiler);
        req.setAttribute("mensaje", "Se cerró el alquiler nro. " + oAlquiler.getId() + " - Placa: " + oAlquiler.getPlaca());
        req.getRequestDispatcher("checkout_park.jsp").forward(req, resp);
    }
}
