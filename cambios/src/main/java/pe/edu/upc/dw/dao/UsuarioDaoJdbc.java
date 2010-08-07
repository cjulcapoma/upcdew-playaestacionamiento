package pe.edu.upc.dw.dao;

import pe.edu.upc.dw.util.JdbcUtils;
import pe.edu.upc.dw.model.Usuario;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Carlos
 */
public class UsuarioDaoJdbc {

    public Usuario getUsuariobyLogin(String vNombre, String vPassword) {
        Usuario usuario = null;
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            final String query = "select * from usuario where id_usuario='" + vNombre + "' and password_usuario='"+vPassword+ "'";
            //System.out.println("query=" + query);
            rs = st.executeQuery(query);

            if (rs.next()) {
                usuario = new Usuario();
                usuario.setNombre(rs.getString("nombre_usuario"));
            }
        } catch (SQLException e) {            
            throw new IllegalStateException("Error al obtener el usuario", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return usuario;
    }
}
