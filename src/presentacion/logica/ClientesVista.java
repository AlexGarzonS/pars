/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package presentacion.logica;

import ControlErrores.ControlErrores;
import bussines.Clientes.ClienteBussines;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Clientes.Clientes;


/**
 *
 * @author Dev
 */
public class ClientesVista 
{
    
    public static void ListaClientes() 
    throws Exception
    {
        Collection<Clientes> collectionClientes;
        
        
        collectionClientes = null;
        try 
        {
            ControlErrores utils;
            ClienteBussines client;

            utils = new ControlErrores();
            client = new ClienteBussines();
            collectionClientes = new ArrayList<>();

            collectionClientes = client.traerListaClientes();
            
            if(utils.isValidCollection(collectionClientes))
            {
            }

           
        } catch (Exception e) 
        {
            System.out.println("Pruebas::main " + "No es posible realizar consulta " + e.getMessage());
        }
    }
}
