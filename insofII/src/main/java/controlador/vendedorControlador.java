/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.productosFacadeLocal;
import EJB.vendedoresFacadeLocal;
import java.io.Serializable;
import java.util.List;
import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.vendedores;
import modelo.productos;
import org.primefaces.PrimeFaces;

/**
 *
 * @author david
 */
@Named
@ViewScoped
public class vendedorControlador implements Serializable{
    private vendedores vendedor;
    private List<productos> productos;
    private productos nuevoProducto;
    
    
    @EJB
    private vendedoresFacadeLocal vendedorEJB;
    
    @EJB
    private productosFacadeLocal productoEJB;
    
    @PostConstruct
    public void init(){
        vendedor = new vendedores();
        nuevoProducto = new productos();
        //TODO productos = productoEJB.findAll();
    }
    public void insertarVendedor(){
        try{
            vendedorEJB.create(vendedor);
        }catch(Exception e){
            System.out.println("Error al insertar vendedor a la base de datos" + e.getMessage());
        }
    }

    public vendedores getVendedor() {
        return vendedor;
    }

    public void setUsuario(vendedores vendedor) {
        this.vendedor = vendedor;
    }

    public vendedoresFacadeLocal getUsuarioEJB() {
        return vendedorEJB;
    }

    public void setUsuarioEJB(vendedoresFacadeLocal vendedorEJB) {
        this.vendedorEJB = vendedorEJB;
    }
    
    
    public List<productos> getProductos() {
        return productos;
    }

    public void setProductos(List<productos> productos) {
        this.productos = productos;
    }

    public productos getNuevoProducto() {
        return nuevoProducto;
    }

    public void setNuevoProducto(productos nuevoProducto) {
        this.nuevoProducto = nuevoProducto;
    }

    public vendedoresFacadeLocal getVendedorEJB() {
        return vendedorEJB;
    }

    public void setVendedorEJB(vendedoresFacadeLocal vendedorEJB) {
        this.vendedorEJB = vendedorEJB;
    }

    public productosFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public void setProductoEJB(productosFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }
    
    public void guardarNuevoProducto() {
    
        System.out.println("SE VA A GUARDAR UN PRODUCTO NUEVO: "+ nuevoProducto.getNombre());
        
        
        //TODO logica de guardado del nuevo producto    
        
        nuevoProducto = new productos();
    }
    
}
