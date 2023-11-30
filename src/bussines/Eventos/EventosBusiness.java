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
 * @author JGARZON
 */
public class EventosBusiness extends ControlErrores {

    /**
     * Consulta todos los estados de los eventos
     *
     * @return coleccion de String
     */
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

    /**
     * Consulta todos los eventos
     *
     * @return coleccion de eventos
     */
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

    /**
     * Funcion encargada de insertar eventos
     *
     * @param documento Documento cliente
     * @param tipoDocumento Tipo documento cliente
     * @param fecha Fecha evento
     * @param nombreEvento Nombre evento
     * @param estado Estado del evento
     * @param descripcion Descripcion del evento
     * @param servicios Diferentes servicios vinculados al evento
     * @param subtotal subtotal de valor evento en caso de tenerlo
     * @return id evento creado
     */
    public int insertarEventoFactura(String documento, String tipoDocumento, Date fecha, String nombreEvento, String estado, String descripcion, String servicios, double subtotal) {
        int id;
        id = 0;
        try {
            int resultado;
            EventosDao DaoEvento;
            DaoEvento = new EventosDao();
            resultado = DaoEvento.InsertarEventoFactura(documento, tipoDocumento, fecha, nombreEvento, estado, descripcion, servicios, subtotal);
            if (resultado > 0) {
                id = resultado;
            }
        } catch (SQLException e) {
            System.out.println("EventosBusiness::insertarEventoFactura " + e.getMessage());
        }
        return id;
    }

    /**
     * Elimina evento por id
     *
     * @param id evento a eliminar
     */
    public void eliminarEventoFactura(int id) {

        try {
            if (id > 0) {
                EventosDao DaoEvento;
                DaoEvento = new EventosDao();
                DaoEvento.eliminarEventoFactura(id);
            }
        } catch (SQLException e) {
            System.out.println("EventosBusiness::insertarEventoFactura " + e.getMessage());
        }
    }

}
