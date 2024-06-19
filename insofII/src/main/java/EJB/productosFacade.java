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
import javax.persistence.Query;
import modelo.vendedores;

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
    
    @Override
    public List<productos> obtenerProductosDeVendedor(vendedores vendedor){
    
        List<productos> listaProductos = new ArrayList<>();
        
        String consulta = "FROM productos p WHERE p.vendedores=:param1";
        Query query = em.createQuery(consulta);
        
        query.setParameter("param1", vendedor);        
        listaProductos = query.getResultList();
        return listaProductos;
    }
}
