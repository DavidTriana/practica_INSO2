/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import modelo.usuarios;

/**
 *
 * @author gueps
 */
@Stateless
public class usuariosFacade extends AbstractFacade<usuarios> implements usuariosFacadeLocal {

    @PersistenceContext(unitName = "inso2bbddPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public usuariosFacade() {
        super(usuarios.class);
    }
    
}
