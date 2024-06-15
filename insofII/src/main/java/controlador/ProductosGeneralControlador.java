/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.productosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.productos;

/**
 *
 * @author david
 */
@Named  //Indicar que la clase esta asociada con un EJB
@ViewScoped //Indicar que solo existe mientras exista la vista asociada
public class ProductosGeneralControlador implements Serializable {

    @EJB
    private productosFacadeLocal productoEJB;

    private List<productos> listaProductos;

    private List<productos> filteredProductos;
    
    private productos productoSeleccionado;
    
    private boolean globalFilterOnly;

    //obtener la lista de productos global, no relacionada con el usuario
    @PostConstruct
    public void init() {
        try {
            listaProductos = productoEJB.findAll();
        } catch (Exception e) {
            e.printStackTrace(); // Imprime la excepción en el log
        }
    }

    public List<productos> getListaProductos() {
        return listaProductos;
    }

    public productosFacadeLocal getProductoEJB() {
        return productoEJB;
    }

    public List<productos> getFilteredProductos() {
        return filteredProductos;
    }

    public void setFilteredProductos(List<productos> filteredProductos) {
        this.filteredProductos = filteredProductos;
    }

    
    public void setProductoEJB(productosFacadeLocal productoEJB) {
        this.productoEJB = productoEJB;
    }
    
     public boolean isGlobalFilterOnly() {
        return globalFilterOnly;
    }

    public void setGlobalFilterOnly(boolean globalFilterOnly) {
        this.globalFilterOnly = globalFilterOnly;
    }

    public void toggleGlobalFilter() {
        globalFilterOnly = !globalFilterOnly;
    }
    
    public productos getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(productos productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }

}
