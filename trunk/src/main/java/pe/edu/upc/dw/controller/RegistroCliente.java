/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.edu.upc.dw.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.edu.upc.dw.model.Cliente;

/**
 *
 * @author oalvarez
 */
public class RegistroCliente extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cliente ocliente = new Cliente();

        HttpSession session = req.getSession();
        List<Cliente> oClientes = (List<Cliente>) session.getAttribute("clientes");
        if (oClientes == null) {
            oClientes = new ArrayList<Cliente>();
        }


        ocliente.setId(1);
        ocliente.setNombre(req.getParameter("txtNombre"));
        ocliente.setDireccion(req.getParameter("txtDireccion"));
        ocliente.setTelefono(req.getParameter("txtTelefono"));
        ocliente.setCorreo(req.getParameter("txtMail"));
        ocliente.setTipo_cliente(req.getParameter("TipoCliente"));

        oClientes.add(ocliente);

        //req.setAttribute("cliente", oClientes);
        session.setAttribute("clientes", oClientes);
        req.getRequestDispatcher("clie_reg.jsp").forward(req, resp);

    }
}
