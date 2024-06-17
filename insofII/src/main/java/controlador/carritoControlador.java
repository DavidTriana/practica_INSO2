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
import EJB.productosFacadeLocal;
import EJB.usuariosFacadeLocal;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

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

    public String irPedidosUsuario() {
        return "pedidosUsuario.xhtml?faces-redirect=true";
    }

    public String irPrincipal() {
        return "principalUsuario.xhtml?faces-redirect=true";
    }

}
