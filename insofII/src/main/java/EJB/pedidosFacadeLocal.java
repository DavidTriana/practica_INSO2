/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.pedidos;

/**
 *
 * @author gueps
 */
@Local
public interface pedidosFacadeLocal {

    void create(pedidos pedidos);

    void edit(pedidos pedidos);

    void remove(pedidos pedidos);

    pedidos find(Object id);

    List<pedidos> findAll();

    List<pedidos> findRange(int[] range);

    int count();
    
}
