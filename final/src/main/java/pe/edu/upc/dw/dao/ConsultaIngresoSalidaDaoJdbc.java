package pe.edu.upc.dw.dao;
import java.text.ParseException;
import pe.edu.upc.dw.util.JdbcUtils;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import pe.edu.upc.dw.model.Abono;
import pe.edu.upc.dw.model.Alquiler;
import pe.edu.upc.dw.model.Cliente;
import pe.edu.upc.dw.model.ConsultaIngresoSalidas;
import pe.edu.upc.dw.model.ConsultaMovimiento;
import pe.edu.upc.dw.model.Espacio;
import pe.edu.upc.dw.model.Local;
import pe.edu.upc.dw.model.Tarjeta;
/**
 *
 * @author Carlos
 */
public class ConsultaIngresoSalidaDaoJdbc {
    public ConsultaIngresoSalidas getIngresoSalidabyQuery(ConsultaIngresoSalidas vconingsal) throws ParseException {
        ConsultaIngresoSalidas vconingsalql=new ConsultaIngresoSalidas();
        Connection connection = null;
        Statement st = null;
        ResultSet rs = null;
        vconingsalql=vconingsal;
        if(vconingsalql.getFechadesde()== null) return null;
        try {
            connection = JdbcUtils.getConnection();
            st = connection.createStatement();
            String query;
            query="select * from consulta_ingresosalida";
            //where id_cliente='" +  vconmosql.getCliente().getId() + "'";
            SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/yyyy");
            SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");
            query = query + " where fecha between '" + df.format(sdf.parse(vconingsalql.getFechadesde())) + "' and '" + df.format(sdf.parse(vconingsalql.getFechahasta())) + "'";
            if (vconingsalql.getId_cliente()!= null){
                query=query + " and nombre_cliente like '%" +  vconingsalql.getId_cliente() + "%'";
                
            }else{
                if (vconingsalql.getPlaca()!= null){
                    query=query + " and placa='" +  vconingsalql.getPlaca() + "'";
                }else{
                    if (vconingsalql.getId_local()!= null){
                        query=query + " and nombre_local like '%" +  vconingsalql.getId_local() + "%'";
                    }
                }
            }
            System.out.println("query=" + query);
            rs = st.executeQuery(query);
            if (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                Local local=new Local();
                Cliente cliente= new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                tarjeta.setCliente(cliente);
                tarjeta.setNro_tarjeta(rs.getString("nro_tarjeta"));
                local.setNombre(rs.getString("nombre_local"));               
                vconingsalql.getAlquileres().add(new Alquiler(rs.getInt("id_alquiler"), String.valueOf(rs.getDate("fecha")), rs.getString("hora_inicio"), rs.getString("hora_fin"), rs.getDouble("importe"), rs.getString("placa"), tarjeta, local, null));
                System.out.println("pasamos if");
            }

            System.out.println("antes de while");
            while (rs.next()) {
                Tarjeta tarjeta = new Tarjeta();
                Local local=new Local();
                Cliente cliente= new Cliente();
                cliente.setId(rs.getInt("id_cliente"));
                cliente.setNombre(rs.getString("nombre_cliente"));
                tarjeta.setCliente(cliente);
                tarjeta.setNro_tarjeta(rs.getString("nro_tarjeta"));
                local.setNombre(rs.getString("nombre_local"));
                vconingsalql.getAlquileres().add(new Alquiler(rs.getInt("id_alquiler"), String.valueOf(rs.getDate("fecha")), rs.getString("hora_inicio"), rs.getString("hora_fin"), rs.getDouble("importe"), rs.getString("placa"), tarjeta, local, null));
                System.out.println("dentro de while");
            }
            System.out.println("fin de while");
        } catch (SQLException e) {
            throw new IllegalStateException("Error al obtener los movimientos", e);
        } finally {
            JdbcUtils.closeResultSet(rs);
            JdbcUtils.closeStatement(st);
            JdbcUtils.closeConnection(connection);
        }
        return vconingsalql;
    }
}
