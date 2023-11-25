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
import modelo.Eventos.Eventos;

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
    
    public Collection<Eventos> consultar() {
        Collection<Eventos> coleccionReturn;
        coleccionReturn = null;
        try {
            Collection<Eventos> coleccion;
            coleccion = new ArrayList<Eventos>();
            EventosDao DaoEvento;
            DaoEvento = new EventosDao();

            coleccion = DaoEvento.consultaEventos();

            if (isValidCollection(coleccion)) {
                coleccionReturn = coleccion;
            }

        } catch (SQLException e) {
            System.out.println("EventosBusiness::consultar " + e.getMessage());
        }

        return coleccionReturn;
    }

    public int insertarEventoFactura(String documento, String tipoDocumento, Date fecha, String nombreEvento, String estado, String descripcion, String servicios, double subtotal) {
        int id;
        id = 0;
        try {
            int resultado;
            EventosDao DaoEvento;
            DaoEvento = new EventosDao();
            resultado =DaoEvento.InsertarEventoFactura(documento, tipoDocumento, fecha, nombreEvento, estado, descripcion, servicios, subtotal);
            if(resultado > 0)
            {
                id = resultado;
            }
        } catch (SQLException e) {
            System.out.println("EventosBusiness::insertarEventoFactura " + e.getMessage());
        }
        return id;
    }
    
    public void eliminarEventoFactura(int id) {

        try {
            if(id > 0)
            {
                EventosDao DaoEvento;
                DaoEvento = new EventosDao();
                DaoEvento.eliminarEventoFactura(id);
            }
        } catch (SQLException e) {
            System.out.println("EventosBusiness::insertarEventoFactura " + e.getMessage());
        }
    }

}
