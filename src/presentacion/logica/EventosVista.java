/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Eventos.EventosBusiness;
import bussines.Servicios.ServiciosBussines;
import java.awt.Choice;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JComboBox;
import modelo.Servicios.Servicios;

/**
 *
 * @author Dev
 */
public class EventosVista {

    private ControlErrores e;
    private ServiciosBussines service;
    private EventosBusiness event;

    private ControlErrores getE() {
        e = new ControlErrores();
        return e;
    }

    private ServiciosBussines getService() {
        service = new ServiciosBussines();
        return service;
    }

    private EventosBusiness getEvent() {
        event = new EventosBusiness();
        return event;
    }

    public JComboBox<String> llenarListaEstados() {
        JComboBox<String> returnser;

        returnser = new JComboBox<>();

        try {
            Collection<String> colecionservicios;

            colecionservicios = new ArrayList<>();

            returnser.setSize(100, 40);
            returnser.addItem("Seleccion");

            colecionservicios = getEvent().traerEstadoEvento();

            if (getE().isValidCollection(colecionservicios)) {
                for (String iterador : colecionservicios) {
                    returnser.addItem(iterador);
                }
            }

        } catch (Exception ex) {
            System.out.println("EventosVista::llenarListaEstados " + ex.getMessage());
        }
        return returnser;
    }

    public Choice llenarListaServicios() {
        Choice returnser;

        returnser = new Choice();

        try {
            Collection<Servicios> colecionservicios;

            colecionservicios = new ArrayList<Servicios>();

            returnser.setSize(209, 320);
            returnser.addItem("0 - Seleccion");

            colecionservicios = getService().traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {
                for (Servicios iterador : colecionservicios) {
                    returnser.addItem(iterador.getId_servcio() + " - " + iterador.getNombre_servicio());
                }
            }

        } catch (Exception ex) {
            System.out.println("EventosVista::llenarListaServicios " + "No es posible realizar consulta " + ex.getMessage());
        }
        return returnser;
    }

    public Object[] llenartablaServicios(String seleccion) {

        Object[] obj;
        obj = null;
        try {
            Collection<Servicios> colecionservicios;

            colecionservicios = new ArrayList<Servicios>();

            colecionservicios = getService().traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {

                String[] parts;
                int id;
                String ids;

                id = 0;
                parts = seleccion.split("-");
                ids = parts[0].trim();

                if (e.isValidString(ids)) {
                    id = Integer.parseInt(ids);
                } else {
                    throw new Exception("No es posible capturar id");
                }

                for (Servicios iterador : colecionservicios) {
                    if (id == iterador.getId_servcio()) {
                        obj = new Object[]{
                            iterador.getNombre_servicio(), iterador.getValor()};
                    }

                }
            }

        } catch (Exception ex) {
            System.out.println("EventosVista::llenartablaServicios " + ex.getMessage());
        }
        return obj;
    }

    public double valorTotalServicios(String seleccion) {

        double obj;
        obj = 0;
        try {
            Collection<Servicios> colecionservicios;
            int seleccioni;
            String[] parts;
            seleccioni = 0;
            colecionservicios = new ArrayList<Servicios>();

            parts = seleccion.split("-");
            seleccioni = Integer.parseInt(parts[0].trim());
            colecionservicios = getService().traerListaServicios();

            if (getE().isValidCollection(colecionservicios)) {
                for (Servicios iterador : colecionservicios) {
                    if (iterador.getId_servcio() == seleccioni) {
                        obj = iterador.getValor();
                    }
                }

            }

        } catch (NumberFormatException ex) {
            System.out.println("EventosVista::valorTotalServicios " + ex.getMessage());
        }
        return obj;
    }

    public void insertarEvento(String doc, String tdoc, Date fechaCaptura, String nombreEvento, String estadoEvento, String descripcion, String servicios, String subtotal,
            double total) {
        try {
            Date fecha;
            double valorTotalSub;
            double valorConvert;
            StringBuilder output;
            SimpleDateFormat formato;
            String fechaFormateada;

            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(servicios);
            valorTotalSub = 0;
            output = new StringBuilder();
            formato = new SimpleDateFormat("yyyy-MM-dd");
            fechaFormateada = formato.format(fechaCaptura);
            fecha = formato.parse(fechaFormateada);
            
            while (matcher.find()) {
                output.append(matcher.group()).append(",");
            }

            if (output.length() > 0) {
                output.deleteCharAt(output.length() - 1);
            }
            if (estadoEvento.equalsIgnoreCase("pendiente")) {
                valorConvert = Double.valueOf(subtotal);
                valorTotalSub = total - valorConvert;
            }

            getEvent().insertarEventoFactura(doc, tdoc, fecha, nombreEvento, estadoEvento, descripcion, output.toString(), valorTotalSub);

        }catch(Exception ex)
        {
            System.out.println("EventosVista::insertarEvento " + ex.getMessage());
        } 

    }

}
