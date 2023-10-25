/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package bussines;

import ControlErrores.CollectionsUtils;
import dao.ClientesDao;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import modelo.Clientes;

/**
 *
 * @author Dev
 */
public class ClienteBussines extends CollectionsUtils{
    
    
    public Collection<Clientes> traerListaClientes()
    {
        Collection<Clientes> coleccionReturn;
        coleccionReturn = null;
        try 
        {
            Collection<Clientes> coleccion;
            coleccion= null;
            ClientesDao DaoCliente;
            DaoCliente = new ClientesDao();
            coleccion = new ArrayList<>();
            
            coleccion = DaoCliente.consultaClientes();
            
            if(isValidCollection(coleccion))
            {
                coleccionReturn = coleccion;
            }
            
        } catch (SQLException e) 
        {
            System.out.println("ClienteBussines::traerListaClientes "+e.getMessage());
        }
        
        return coleccionReturn;
    }
}
