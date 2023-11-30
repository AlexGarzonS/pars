package modelo.Eventos;

import java.util.Date;

/**
 *
 * @author JGARZON
 */
public class Eventos {

    /**
     * Atributo nombre Evento
     */
    private String nombre;
    /**
     * Atributo Descripcion Evento
     */
    private String descripcion;
    /**
     * Atributo estado Evento
     */
    private String estado;
    /**
     * Atrivuto Fecha Evento
     */
    private Date fecha;
    /**
     * Atributo id evento
     */
    private int id_evento;

    public int getId_evento() {
        return id_evento;
    }

    public void setId_evento(int id_evento) {
        this.id_evento = id_evento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
