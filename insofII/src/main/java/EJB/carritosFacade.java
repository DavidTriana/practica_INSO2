/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.carritos;
import modelo.usuarios;

/**
 *
 * @author gueps
 */
@Stateless
public class carritosFacade extends AbstractFacade<carritos> implements carritosFacadeLocal {

    @PersistenceContext(unitName = "inso2bbddPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public carritosFacade() {
        super(carritos.class);
    }
    
    @Override
    public carritos findCarritoByUsuario(usuarios usuario){
        String consulta = "FROM carritos c WHERE c.usuario.idUsuario=:param1";
        Query query = em.createQuery(consulta);
        
        query.setParameter("param1", usuario.getIdUsuario());
        List<carritos> resultado = query.getResultList();
        if(!resultado.isEmpty()){
            return resultado.get(0);
        }else{
            return null;
        }
        
        /*try{
            return em.createQuery("SELECT c FROM carritos c WHERE c.usuario.idUsuario = :idUsuario", carritos.class).setParameter("idUsuario", usuario.getIdUsuario()).getSingleResult();
            
        }catch (NoResultException e){
            return null;
        }
*/
    }
    
    @Override
    public void removeCarritoByUsuario(usuarios usuario){
        carritos carrito = findCarritoByUsuario(usuario);
        if(carrito != null){
            em.remove(carrito);
        }
    }
    
}
