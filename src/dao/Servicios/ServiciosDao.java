/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao.Servicios;

import ControlErrores.ControlErrores;
import connection.ConnectionDb;
import static connection.ConnectionDb.closeCall;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosDao extends ConnectionDb {

    private static final String cs_CONSULTASERVICIOS = "Select * from servicios ";

    private static final String cs_INSERTAR_SERVICIO = "{call sp_InsertarServicio(?,?,?)}";
    private static final String cs_ACTUALIZAR_SERVICIO = "UPDATE servicios set ";

    public Collection<Servicios> consultaServicios()
            throws SQLException {
        Collection<Servicios> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            coleccionRetorno = new ArrayList<>();
            ps = conectar().prepareStatement(cs_CONSULTASERVICIOS);
            rs = ps.executeQuery();

            while (rs.next()) {
                coleccionRetorno.add(getDataServices(rs));
            }
        } catch (SQLException e) {
            System.out.println("ServiciosDao::consultaServicios " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
            CerraConector();
        }

        return coleccionRetorno;
    }

    public Servicios buscarValorServicio(double a_id)
            throws SQLException {
        Servicios retorno;
        PreparedStatement ps;
        ResultSet rs;

        retorno = new Servicios();
        ps = null;
        rs = null;

        try {
            if (a_id > 0) {
                StringBuilder query;
                query = new StringBuilder(cs_CONSULTASERVICIOS);

                query.append("where servicioID =");
                query.append(a_id);

                ps = conectar().prepareStatement(query.toString());
                rs = ps.executeQuery();

                if (rs.next()) {
                    retorno = getDataServices(rs);
                }
            }
        } catch (SQLException e) {
            System.out.println("ServiciosDao::buscarValorServicio " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
            CerraConector();
        }
        return retorno;
    }

    public void insertServicio(Servicios a_servicio)
            throws SQLException {
        CallableStatement statement;
        statement = null;

        try {

            if (a_servicio != null) 
            {
                int in;
                in = 1;
                
                statement = conectar().prepareCall(cs_INSERTAR_SERVICIO);
                
                statement.setString(in++, a_servicio.getNombre_servicio());
                statement.setString(in++, a_servicio.getDescripcion());
                statement.setDouble(in++, a_servicio.getValor());

                statement.execute();
            }

        } catch (SQLException e) {
            System.out.println("EventosDao::eliminarEventoFactura " + e.getMessage());
        } finally {
            closeCall(statement);
            CerraConector();
        }

    }

    public void UpdateServicio(String a_script)
            throws SQLException {
        PreparedStatement ps;
        ps = null;

        try {
            ControlErrores e;
            e = new ControlErrores();

            if (e.isValidString(a_script)) {
                StringBuilder query;
                query = new StringBuilder(cs_ACTUALIZAR_SERVICIO);
                query.append(a_script);

                ps = conectar().prepareStatement(query.toString());
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println("ServiciosDao::UpdateServicio " + e.getMessage());
        } finally {
            CerraConector();
            closePs(ps);
        }

    }

    private Servicios getDataServices(ResultSet ars)
            throws SQLException {
        Servicios returnServices;
        returnServices = new Servicios();

        returnServices.setId_servcio(ars.getInt("servicioID"));
        returnServices.setDescripcion(ars.getString("descripcion"));
        returnServices.setNombre_servicio(ars.getString("nombre_Servicio"));
        returnServices.setValor(ars.getDouble("valor"));

        return returnServices;
    }

}
