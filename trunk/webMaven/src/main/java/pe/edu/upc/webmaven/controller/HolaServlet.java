/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.webmaven.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author u201000173
 */
public class HolaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String sNombre = req.getParameter("nombre");
        String sApellido = req.getParameter("apellido");

        PrintWriter writer = resp.getWriter();
        writer.println("Hello World!  " + sNombre + " " + sApellido);
        writer.close();
        //super.doGet(req, resp);

    }



}
