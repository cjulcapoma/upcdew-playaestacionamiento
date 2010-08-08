/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.edu.upc.dw.dao;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.util.JdbcUtils;
/**
 *
 * @author oalvarez
 */
public class LocalDaoJdbc {
    public Local buscarLocal(Local oLocal) {
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        Local oLocalEncontrado = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String sQuery = "Select Id_Local, Nombre, Direccion, Telefono, Cantidad_Espacios, Tolerancia, Precio_x_Hora, Porc_Desc_Tarjeta " +
                    " from dew.Local where Id_Local = '" + oLocal.getId() + "'";
            rs = st.executeQuery(sQuery);
            if (rs.next()) {
                oLocalEncontrado = new Local();
                oLocalEncontrado.setId(rs.getInt("Id_Local"));
                oLocalEncontrado.setNombre(rs.getString("Nombre"));
                oLocalEncontrado.setDireccion(rs.getString("Direccion"));
                oLocalEncontrado.setTelefono(rs.getString("Telefono"));
                oLocalEncontrado.setCant_espacios(rs.getString("Cantidad_espacios"));
                oLocalEncontrado.setTolerancia(rs.getString("Tolerancia"));
                oLocalEncontrado.setPrecio_hora(rs.getString("Precio_X_Hora"));
                oLocalEncontrado.setPorc_dscto_tarjeta(rs.getString("Porc_desc_Tarjeta"));
            }


        } catch (SQLException ex) {
            throw new IllegalStateException("Error al obtener el local", ex);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return oLocalEncontrado;
    }
}
