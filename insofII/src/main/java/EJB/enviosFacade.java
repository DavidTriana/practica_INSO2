/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import controlador.UsuarioControlador;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import modelo.envios;
import modelo.productos;
import modelo.usuarios;

/**
 *
 * @author gueps
 */
@Stateless
public class enviosFacade extends AbstractFacade<envios> implements enviosFacadeLocal {

    @PersistenceContext(unitName = "inso2bbddPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public enviosFacade() {
        super(envios.class);
    }

    @Override
    public List<envios> obtenerEnviosUsuario(usuarios usuario) {
        String consulta = "FROM envios e WHERE e.usuario.idUsuario=:param1";
        Query query = em.createQuery(consulta);

        query.setParameter("param1", usuario.getIdUsuario());
        List<envios> resultado = query.getResultList();
        return query.getResultList();

        /*Query q = em.createQuery("SELECT e FROM Envios e WHERE e.usuario = :usuario");
        q.setParameter("usuario", usuario);
        return q.getResultList();*/
    }

    @Override
    public List<productos> obtenerProductosEnvio(String productosString) {
        if (productosString == null || productosString.isEmpty()) {
            return null;
        }

        List<Integer> ids = Arrays.stream(productosString.split(",")).map(String::trim).map(Integer::parseInt).collect(Collectors.toList());
        
        String consulta = "FROM productos p WHERE p.idProducto IN :ids";
        Query query = em.createQuery(consulta);
        query.setParameter("ids", ids);

        return query.getResultList();
    }

}
