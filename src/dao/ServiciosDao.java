/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import connection.ConnectionDb;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosDao extends ConnectionDb {

    private static final String cs_CONSULTASERVICIOS = "Select * from servicios";

    public Collection<Servicios> consultaServicios()
            throws SQLException {
        Collection<Servicios> coleccionRetorno;
        PreparedStatement ps;
        ResultSet rs;

        coleccionRetorno = null;
        ps = null;
        rs = null;

        try {
            ps = conectar().prepareStatement(cs_CONSULTASERVICIOS);
            rs = ps.executeQuery();
            coleccionRetorno = new ArrayList<>();

            while (rs.next()) {
                coleccionRetorno.add(getDataServices(rs));
            }
        } catch (SQLException e) {
            System.out.println("ServiciosDao::consultaServicios " + e.getMessage());
        } finally {
            closeRs(rs);
            closePs(ps);
        }

        return coleccionRetorno;
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
