/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
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

    @Override
    public usuarios verificarUsuario(usuarios usuario) {
        String consulta = "FROM usuarios u WHERE u.nombre=:param1 and u.contrasenia=:param2";

        Query query = em.createQuery(consulta);

        query.setParameter("param1", usuario.getNombre());
        System.out.println(usuario.getNombre());
        query.setParameter("param2", usuario.getContrasenia());
        System.out.println(usuario.getContrasenia());
        
        List<usuarios> resultado = query.getResultList();

        if (!resultado.isEmpty()) {
            return resultado.get(0);
        } else {
            return null;
        }
    }

}
