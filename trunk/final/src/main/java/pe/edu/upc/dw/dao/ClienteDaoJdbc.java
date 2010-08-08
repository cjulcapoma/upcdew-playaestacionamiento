/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.model.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

         public Cliente InsertarCliente(Cliente cliente) {
//        Cliente cliente = null;
        String cmdCliente;
        String sQuery;
        PreparedStatement pstm;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        int nIdCliente = 0;
        int nOk = 0;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            sQuery = "Select Max(Id_Cliente) + 1 From Dew.Cliente";
            rs = st.executeQuery(sQuery);

            if (rs.next()) {
                nIdCliente = rs.getInt(1);
                if (nIdCliente == 0) {
                    nIdCliente = 1;
                }
            }
            cliente.setId(nIdCliente);
            st = connection.createStatement();

            cmdCliente = "INSERT INTO cliente(id_cliente, dni_cliente, nombre, direccion, telefono,tipo_cliente,estado,email) " + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            pstm = connection.prepareStatement(cmdCliente);
            pstm.setInt(1, cliente.getId());
            pstm.setString(2, cliente.getDni());
            pstm.setString(3, cliente.getNombre());
            pstm.setString(4, cliente.getDireccion());
            pstm.setString(5, cliente.getTelefono());
            pstm.setString(6, cliente.getTipo_cliente());
            pstm.setString(7, cliente.getEstado());
            pstm.setString(8, cliente.getCorreo());
            pstm.executeUpdate();


        } catch (SQLException e) {
            throw new IllegalStateException("Error al registrar el cliente", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return cliente;
    }

     public Cliente Buscar(String DNI) {

        String cmdCliente;
        PreparedStatement pstm;
        Cliente cliente = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            cmdCliente = "SELECT * FROM cliente WHERE dni_cliente = ? ";

            pstm = connection.prepareStatement(cmdCliente);
            pstm.setString(1, DNI);
            rs = pstm.executeQuery();

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setTipo_cliente(rs.getString("tipo_cliente"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCorreo(rs.getString("email"));

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }

     public List<Cliente> MostrarTodos() {
        String cmdCliente;
        PreparedStatement pstm;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        List<Cliente> list = null;
        Cliente cliente;

        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            cmdCliente = "SELECT * FROM CLIENTE";
            pstm = connection.prepareStatement(cmdCliente);
            rs = pstm.executeQuery();
            list = new ArrayList();

            while (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setTipo_cliente(rs.getString("tipo_cliente"));
                cliente.setEstado(rs.getString("estado"));
                cliente.setCorreo(rs.getString("email"));

                list.add(cliente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return list;
    }

     public Cliente getClientebyDNI(String vDni) {
        Cliente cliente = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select * from cliente where dni_cliente='" + vDni + "'";
            System.out.println("query=" + query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                cliente = new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setDni(rs.getString("dni_cliente"));
                cliente.setNombre(rs.getString("nombre"));
                cliente.setDireccion(rs.getString("direccion"));
                cliente.setTelefono(rs.getString("telefono"));
                cliente.setCorreo(rs.getString("email"));
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
