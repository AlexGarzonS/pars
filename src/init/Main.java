/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package init;

import ControlErrores.CollectionsUtils;
import bussines.ClienteBussines;
import bussines.ServiciosBussines;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Clientes;
import modelo.Servicios;

/**
 *
 * @author Dev
 */
public class Main {

    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) {
        System.out.println("Clientes");
        ListaClientes();
        System.out.println(" ");
        System.out.println("Servicios");
        Listaservicios();
    }

    public static void Listaservicios() {
        Collection<Servicios> collectionServices;
        collectionServices = null;
        try {
            CollectionsUtils utils;
            ServiciosBussines service;

            utils = new CollectionsUtils();
            service = new ServiciosBussines();
            collectionServices = new ArrayList<>();

            collectionServices = service.traerListaServicios();

            if (utils.isValidCollection(collectionServices)) {
                for (Servicios iterador : collectionServices) {
                    System.out.println("id servicio: " + iterador.getId_servcio());
                    System.out.println("Nombre servicio " + iterador.getNombre_servicio());
                    System.out.println("Descripcion: " + iterador.getDescripcion());
                    System.out.println("Valor: " + iterador.getValor());
                }
            } else {
                System.out.println("No hay datos");
            }
        } catch (Exception e) {
            System.out.println("Pruebas::main " + "No es posible realizar consulta " + e.getMessage());
        }
    }
    
    public static void ListaClientes() {
        Collection<Clientes> collectionClientes;
        collectionClientes = null;
        try {
            CollectionsUtils utils;
            ClienteBussines client;

            utils = new CollectionsUtils();
            client = new ClienteBussines();
            collectionClientes = new ArrayList<>();

            collectionClientes = client.traerListaClientes();

            if (utils.isValidCollection(collectionClientes)) {
                for (Clientes iterador : collectionClientes) {
                    System.out.println("id cliente: " + iterador.getId_cliente());
                    System.out.println("Nombre: " + iterador.getNombre());
                    System.out.println("email: " + iterador.getEmail());
                    System.out.println("tipo documento: " + iterador.getTipoDoc());
                    System.out.println("documento: " + iterador.getNumeroDocumento());
                }
            } else {
                System.out.println("No hay datos");
            }
        } catch (Exception e) {
            System.out.println("Pruebas::main " + "No es posible realizar consulta " + e.getMessage());
        }
    }
}
