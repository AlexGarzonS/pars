/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Eventos;

import ControlErrores.ControlErrores;
import connection.ConnectionDb;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import modelo.Eventos.Eventos;

/**
 *
 * @author Dev
 */
public class EventosDao extends ConnectionDb {

    private static final String cs_ESTADOS_EVENTO = "select DISTINCT Estado from Eventos";
    private static final String cs_SP_EVENTO_FACTURA = "{call sp_CrearNuevoEventoFactura(?, ?, ?, ?, ?, ?, ?, ?)}";

    public Collection<String> consultaEstadoEvento()
            throws SQLException {
        Collection<String> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            coleccionRetorno = new ArrayList<>();
            ps = conectar().prepareStatement(cs_ESTADOS_EVENTO);
            rs = ps.executeQuery();

            while (rs.next()) {
                coleccionRetorno.add(rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println("EventosDao::consultaEstadoEvento " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
            CerraConector();
        }

        return coleccionRetorno;
    }

    public void InsertarEventoFactura(String documento, String tipoDocumento, Date fecha, String nombreEvento, String estado, String descripcion, String servicios, double subtotal)
            throws SQLException {
        CallableStatement statement;

        statement = null;

        try {
            int in;
            ControlErrores er;
            er = new ControlErrores();
            in = 1;

            statement = conectar().prepareCall(cs_SP_EVENTO_FACTURA);
            statement.setString(in++, documento);
            statement.setString(in++, tipoDocumento);
            statement.setString(in++, nombreEvento);
            statement.setString(in++, descripcion);
            statement.setString(in++, servicios);
            statement.setString(in++, estado);
            statement.setDate(in++, er.convertirFechaUtilASQL(fecha));
            statement.setDouble(in++, subtotal);
            statement.execute();

        } catch (SQLException e) {
            System.out.println("EventosDao::InsertarEventoFactura " + e.getMessage());
        } finally {
            closeCall(statement);
            CerraConector();
        }

    }

    private Eventos getDataEventos(ResultSet ars)
            throws SQLException {
        Eventos returnServices;
        returnServices = new Eventos();

        /* returnServices.setId_servcio(ars.getInt("servicioID"));
        returnServices.setDescripcion(ars.getString("descripcion"));
        returnServices.setNombre_servicio(ars.getString("nombre_Servicio"));
        returnServices.setValor(ars.getDouble("valor"));*/
        return returnServices;
    }

}
