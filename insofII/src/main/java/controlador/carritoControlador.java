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
 
/**
 *
 * @author gueps
 */

@Named
@SessionScoped

public class carritoControlador implements Serializable{
    
    @EJB
    private carritosFacadeLocal carritoFacade;
    private carritos carritoActual;
    
    public carritoControlador(){
        
    }
    
    public carritos getCarritoActual(){
        return carritoActual;
    }
    
    public void setCarritoActual(carritos carritoActual){
        this.carritoActual = carritoActual;
    }
    
    // Método para inicializar el carrito actual del usuario
   
}
