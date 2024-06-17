/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import modelo.carritos;
import modelo.productos;
import modelo.usuarios;
import EJB.carritosFacadeLocal;
import EJB.enviosFacadeLocal;
import EJB.productosFacadeLocal;
import EJB.usuariosFacadeLocal;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import modelo.envios;

/**
 *
 * @author gueps
 */
@Named
@ViewScoped

public class carritoControlador implements Serializable {

    @EJB
    private carritosFacadeLocal carritosFacade;

    @EJB
    private usuariosFacadeLocal usuariosFacade;

    @EJB
    private productosFacadeLocal productosFacade;
    
    @EJB
    private enviosFacadeLocal enviosFacade;

    @Inject
    private UsuarioControlador usuarioControlador;

    private carritos carrito;
    private List<productos> productosList;

    public carritoControlador() {

    }

    // Método para inicializar el carrito actual del usuario
    @PostConstruct
    public void init() {
        usuarios user = usuarioControlador.getUsuario();
        System.out.println("usuario en la sesion: " + user);
        if (user != null) {
            carrito = carritosFacade.findCarritoByUsuario(user);

            if (carrito != null) {
                String[] productosIds = carrito.getProductos().split(",");
                productosList = new ArrayList<>();
                for (String productoId : productosIds) {
                    productos product = productosFacade.find(Integer.parseInt(productoId));
                    productosList.add(product);
                }
            }
        }
    }
    
    public String comprarCarrito(){
        if(carrito != null && carrito.getCosteTotal() > 0){
            envios envio = new envios();
            envio.setUsuario(carrito.getUsuario());
            envio.setProductos(carrito.getProductos());
            envio.setPrecioTotal(carrito.getCosteTotal());
            
            /*Obtener fecha y hota*/
            String fechaActual = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            String horaActual = new SimpleDateFormat("HH:mm:ss").format(new Date());
            
            envio.setFecha(fechaActual);
            envio.setHora(horaActual);
            envio.setEstado("Pendiente");
            
            enviosFacade.create(envio);
            carritosFacade.remove(carrito);
            
            carrito = null;
            
            
            /*redirigir*/
            return "principalUsuario.xhtml?faces-redirect=true";
        }
        return "";
    }
    
    
    public String eliminarCarrito(){
        usuarios user = usuarioControlador.getUsuario();
        if( user != null){
            carritosFacade.removeCarritoByUsuario(user);
        return "carritoUsuario.xhtml?faces-redirect=true";
        }
        return "";
    }

    /* Getters y setters */
    public carritos getCarrito() {
        return carrito;
    }

    public List<productos> getProductList() {
        return productosList;
    }

    public String irCarrito() {
        return "carritoUsuario.xhtml?faces-redirect=true";
    }

    public String irProductos() {
        return "productosGeneral.xhtml?faces-redirect=true";
    }

    public String irEnviosUsuario() {
        return "enviosUsuario.xhtml?faces-redirect=true";
    }

    public String irPrincipal() {
        return "principalUsuario.xhtml?faces-redirect=true";
    }

}
