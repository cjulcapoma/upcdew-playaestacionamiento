/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.model.Cliente;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class ClienteDaoJdbc {
    
    public Cliente getClientebyLogin(String vNombre, String vPassword) {
        Cliente cliente = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select * from cliente where dni_cliente='" + vNombre + "' and password='"+vPassword+ "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);
            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setTipo_cliente(rs.getString("tipo_cliente"));                
            }
        } catch (SQLException e) {
            throw new IllegalStateException("Error al obtener el cliente", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return cliente;
    }

}
