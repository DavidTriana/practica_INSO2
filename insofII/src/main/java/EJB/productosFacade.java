/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.productos;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gueps
 */
@Stateless
public class productosFacade extends AbstractFacade<productos> implements productosFacadeLocal {

    @PersistenceContext(unitName = "inso2bbddPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public productosFacade() {
        super(productos.class);
    }
    
    public void guardarProducto(productos producto) {
        
        System.out.println("se va a guardar el producto "+ producto.getNombre());
    }
    
}
