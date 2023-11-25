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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Types;
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
    private static final String cs_SP_EVENTO_FACTURA = "{call sp_CrearNuevoEventoFactura(?, ?, ?, ?, ?, ?, ?, ?,?)}";
    private static final String cs_CONSULTAREVENTOS = "select * from Eventos";
    private static final String cs_SP_ELIMINAR_EVENTO_FACTURA = "{call sp_EliminarEventoFactura(?)}";

    public Collection<Eventos> consultaEventos()
            throws SQLException {
        Collection<Eventos> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            coleccionRetorno = new ArrayList<Eventos>();
            ps = conectar().prepareStatement(cs_CONSULTAREVENTOS);
            rs = ps.executeQuery();

            while (rs.next()) {
                coleccionRetorno.add(getDataEventos(rs));
            }
        } catch (SQLException e) {
            System.out.println("EventosDao::consultaEventos " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
            CerraConector();
        }

        return coleccionRetorno;
    }

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

    public int InsertarEventoFactura(String documento, String tipoDocumento, Date fecha, String nombreEvento, String estado, String descripcion, String servicios, double subtotal)
            throws SQLException {

        int id;
        CallableStatement statement;

        id = 0;
        statement = null;

        try {
            int in;
            int ultimo;
            int resultado;
            ControlErrores er;
            er = new ControlErrores();
            in = 1;
            ultimo = 0;

            statement = conectar().prepareCall(cs_SP_EVENTO_FACTURA);
            statement.setString(in++, documento);
            statement.setString(in++, tipoDocumento);
            statement.setString(in++, nombreEvento);
            statement.setString(in++, descripcion);
            statement.setString(in++, servicios);
            statement.setString(in++, estado);
            statement.setDate(in++, er.convertirFechaUtilASQL(fecha));
            statement.setDouble(in++, subtotal);
            statement.registerOutParameter(in++, Types.INTEGER);
            ultimo = statement.getParameterMetaData().getParameterCount();
            statement.execute();

            if (ultimo > 0) {
                resultado = statement.getInt(ultimo);

                if (resultado > 0) {
                    id = resultado;
                } else {
                    throw new SQLDataException("El proceso no se ejecuto");
                }
            }

        } catch (SQLException e) {
            System.out.println("EventosDao::InsertarEventoFactura " + e.getMessage());
        } finally {
            closeCall(statement);
            CerraConector();
        }
        return id;
    }

    public int eliminarEventoFactura(int id)
            throws SQLException {

        CallableStatement statement;
        statement = null;

        try {

            if (id <= 0) {
                throw new SQLException("Valor de id no debe ser 0 o inferior");
            }
            statement = conectar().prepareCall(cs_SP_ELIMINAR_EVENTO_FACTURA);
            statement.setInt(1, id);

            statement.execute();

        } catch (SQLException e) {
            System.out.println("EventosDao::eliminarEventoFactura " + e.getMessage());
        } finally {
            closeCall(statement);
            CerraConector();
        }
        return id;
    }

    private Eventos getDataEventos(ResultSet ars)
            throws SQLException {
        Eventos returnServices;
        returnServices = new Eventos();

        returnServices.setId_evento(ars.getInt("eventoID"));
        returnServices.setNombre(ars.getString("nombre"));
        returnServices.setFecha(ars.getDate("fecha"));
        returnServices.setDescripcion(ars.getString("descripcion"));
        returnServices.setEstado(ars.getString("estado"));

        return returnServices;
    }

}
