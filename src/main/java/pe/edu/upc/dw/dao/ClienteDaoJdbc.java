/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.dao;
import pe.edu.upc.dw.util.JdbcUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.upc.dw.model.Cliente;
/**
 *
 * @author Hellsing
 */
public class ClienteDaoJdbc {

     public Cliente InsertarCliente(Cliente cliente) {
//        Cliente cliente = null;
        String cmdCliente;
        PreparedStatement pstm;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
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
            throw new IllegalStateException("Error al obtener el usuario", e);
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
                cliente.setNombre(rs.getString("nombre_cliente"));
                cliente.setDireccion(rs.getString("direccion"));
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return cliente;
    }


}
