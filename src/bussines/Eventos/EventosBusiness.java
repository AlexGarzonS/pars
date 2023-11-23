/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines.Eventos;

import ControlErrores.ControlErrores;
import dao.Eventos.EventosDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author Dev
 */
public class EventosBusiness extends ControlErrores {

    public Collection<String> traerEstadoEvento() {
        Collection<String> coleccionReturn;
        coleccionReturn = null;
        try {
            Collection<String> coleccion;
            coleccion = new ArrayList<>();
            EventosDao DaoEvento;
            DaoEvento = new EventosDao();

            coleccion = DaoEvento.consultaEstadoEvento();

            if (isValidCollection(coleccion)) {
                coleccionReturn = coleccion;
            }

        } catch (SQLException e) {
            System.out.println("EventosBusiness::traerEstadoEvento " + e.getMessage());
        }

        return coleccionReturn;
    }

    public void insertarEventoFactura(String documento, String tipoDocumento, Date fecha, String nombreEvento, String estado, String descripcion, String servicios, double subtotal) {
        try {
            EventosDao DaoEvento;
            DaoEvento = new EventosDao();
            DaoEvento.InsertarEventoFactura(documento, tipoDocumento, fecha, nombreEvento, estado, descripcion, servicios, subtotal);
        } catch (SQLException e) {
            System.out.println("EventosBusiness::insertarEventoFactura " + e.getMessage());
        }

    }

}
