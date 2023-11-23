/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.Servicios;

import ControlErrores.ControlErrores;
import dao.Servicios.ServiciosDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Servicios.Servicios;

/**
 *
 * @author Dev
 */
public class ServiciosBussines extends ControlErrores {

    public Collection<Servicios> traerListaServicios() {
        Collection<Servicios> coleccionReturn;
        coleccionReturn = null;
        try {
            Collection<Servicios> coleccion;
            coleccion = new ArrayList<Servicios>();
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();

            coleccion = DaoServicio.consultaServicios();

            if (isValidCollection(coleccion)) {
                coleccionReturn = coleccion;
            }

        } catch (SQLException e) {
            System.out.println("ServiciosBussines::traerListaServicios " + e.getMessage());
        }

        return coleccionReturn;
    }

    public void insertarServicio(Servicios a_servicios) {
        try {
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();

            if (a_servicios != null) {
                DaoServicio.insertServicio(a_servicios);
            }

        } catch (SQLException e) {
            System.out.println("ServiciosBussines::insertarServicio" + e.getMessage());
        }
    }

    public void actualizarServicio(Servicios a_servicio) {
        try {
            ServiciosDao DaoServicio;
            DaoServicio = new ServiciosDao();

            if (a_servicio != null) {
                boolean isnombre;
                boolean isdescripcion;
                boolean isvalor;
                boolean istres;
                boolean isdos1;
                boolean isdos2;
                boolean isdos3;
                double valorSer;
                int idServicio;
                Servicios servicio;
                String nombreSer;
                String descripcionSer;
                String where;
                StringBuilder query;
                ControlErrores error;

                error = new ControlErrores();
                servicio = new Servicios();
                isnombre = false;
                isdescripcion = false;
                isvalor = false;
                istres = false;
                isdos1 = false;
                isdos2 = false;
                isdos3 = false;
                valorSer = a_servicio.getValor();
                idServicio = a_servicio.getId_servcio();
                nombreSer = a_servicio.getNombre_servicio();
                descripcionSer = a_servicio.getDescripcion();
                where = " where servicioID =" + idServicio;
                servicio = DaoServicio.buscarValorServicio(idServicio);
                query = null;

                if (servicio != null) {
                    isnombre = error.compareString(servicio.getNombre_servicio(), nombreSer);
                    isdescripcion = error.compareString(servicio.getDescripcion(), descripcionSer);
                    isvalor = error.compareDoble(servicio.getValor(), valorSer);

                } else {
                    throw new SQLException("No es posible identificar ssrvicio");
                }

                istres = isnombre && isdescripcion && isvalor;

                isdos1 = isnombre && isdescripcion && !isvalor;
                isdos2 = isnombre && !isdescripcion && isvalor;
                isdos3 = !isnombre && isdescripcion && isvalor;

                if (istres) {
                    query = new StringBuilder();
                    query.append("nombre_Servicio = ");
                    query.append("'").append(nombreSer).append("', ");
                    query.append("descripcion = ");
                    query.append("'").append(descripcionSer).append("'");
                    query.append("valor = ");
                    query.append(valorSer);
                }

                if (isdos1) {
                    query = new StringBuilder();
                    query.append("nombre_Servicio = ");
                    query.append("'").append(nombreSer).append("', ");
                    query.append("descripcion = ");
                    query.append("'").append(descripcionSer).append("'");
                }

                if (isdos2) {
                    query = new StringBuilder();
                    query.append("nombre_Servicio = ");
                    query.append("'").append(nombreSer).append("', ");
                    query.append("valor = ");
                    query.append(valorSer);
                }

                if (isdos3) {
                    query = new StringBuilder();
                    query.append("descripcion = ");
                    query.append("'").append(descripcionSer).append("'");
                    query.append("valor = ");
                    query.append(valorSer);
                }

                if (isnombre) {
                    query = new StringBuilder();
                    query.append("nombre_Servicio = ");
                    query.append("'").append(nombreSer).append("'");
                }
                if (isdescripcion) {
                    query = new StringBuilder();
                    query.append("descripcion = ");
                    query.append("'").append(descripcionSer).append("'");
                }
                if (isvalor) {
                    query = new StringBuilder();
                    query.append("valor = ");
                    query.append(valorSer);
                }

                if (error.isValidString(query.toString())) {
                    query.append(where);
                    DaoServicio.UpdateServicio(query.toString());
                } else {
                    throw new SQLException("No se realizo modificación ya que no se especifican datos para cambiar");
                }
            }
        } catch (SQLException e) {
            System.out.println("ServiciosBussines::actualizarServicio" + e.getMessage());
        }
    }

}
