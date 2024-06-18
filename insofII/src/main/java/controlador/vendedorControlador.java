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
import java.util.Arrays;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.vendedores;
import modelo.productos;
import org.primefaces.PrimeFaces;
import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.optionconfig.title.Title;

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
    private productos productoSeleccionado;
    
    private BarChartModel barModel;
    private int anchoGrafico;

    public int getAnchoGrafico() {
        return anchoGrafico;
    }

    public void setAnchoGrafico(int anchoGrafico) {
        this.anchoGrafico = anchoGrafico;
    }


    public BarChartModel getBarModel() {
        return barModel;
    }

    public void setBarModel(BarChartModel barModel) {
        this.barModel = barModel;
    }

    public productos getProductoSeleccionado() {
        return productoSeleccionado;
    }

    public void setProductoSeleccionado(productos productoSeleccionado) {
        this.productoSeleccionado = productoSeleccionado;
    }
    
    
    @EJB
    private vendedoresFacadeLocal vendedorEJB;
    
    @EJB
    private productosFacadeLocal productoEJB;
    
    @PostConstruct
    public void init(){
        vendedor = new vendedores();
        nuevoProducto = new productos();
        //TODO productos = productoEJB.findAll();
        
        vendedor = (vendedores) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        System.out.println("el vendedor es: "+ vendedor.getNombre());
        
        productos = productoEJB.obtenerProductosDeVendedor(vendedor);
        crearTabla();
    }
    public void insertarVendedor(){
        try{
            vendedorEJB.create(vendedor);
        }catch(Exception e){
            System.out.println("Error al insertar vendedor a la base de datos" + e.getMessage());
        }
    }

    private void crearTabla() {
    
        barModel = new BarChartModel();
        
        ChartData data = new ChartData();

        BarChartDataSet barDataSet = new BarChartDataSet();
        barDataSet.setLabel("Sales");

        // Datos de ventas por producto
        
        List<String> nombresProductos = new ArrayList<>();
        List<Number> preciosProductos = new ArrayList<>();
        
        for (int i=0; i<productos.size(); i++){
            
            nombresProductos.add(productos.get(i).getNombre());
            preciosProductos.add(productos.get(i).getPrecio());
        }
        
        barDataSet.setData(preciosProductos);
        barDataSet.setBackgroundColor("rgba(75, 192, 192, 0.2)");
        barDataSet.setBorderColor("rgb(75, 192, 192)");
        barDataSet.setBorderWidth(1);

        data.addChartDataSet(barDataSet);
        
        List<String> labels = nombresProductos;
        data.setLabels(labels);

        barModel.setData(data);

        anchoGrafico = productos.size() > 6 ? productos.size() * 100 : 600;
    
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
                
        nuevoProducto.setVendedores(vendedor);
        
        productoEJB.create(nuevoProducto);
        //TODO logica de guardado del nuevo producto    
        
        //nuevoProducto = new productos();
    }
    
    public void eliminarProducto(){
    
        System.out.println("se va a eliminar un producto");
    
    }
    
    public String refrescar(){
    
        return "privado/vendedor/principalVendedor.xhtml?faces-redirect=true";
    }
}
