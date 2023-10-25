/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Dev
 */
public class Servicios {

    private int id_servcio;
    private String nombre_servicio;
    private String descripcion;
    private double valor;

    public int getId_servcio() {
        return id_servcio;
    }

    public void setId_servcio(int id) {
        id_servcio = id;
    }

    public String getNombre_servicio() {
        return nombre_servicio;
    }

    public void setNombre_servicio(String nombre) {
        nombre_servicio = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String desc) {
        descripcion = desc;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double val) {
        valor = val;
    }
    
    
}
