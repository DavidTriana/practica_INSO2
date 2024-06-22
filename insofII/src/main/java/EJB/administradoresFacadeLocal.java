/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package EJB;

import java.util.List;
import javax.ejb.Local;
import modelo.administradores;

/**
 *
 * @author gueps
 */
@Local
public interface administradoresFacadeLocal {

    void create(administradores administradores);

    void edit(administradores administradores);

    void remove(administradores administradores);

    administradores find(Object id);

    List<administradores> findAll();

    List<administradores> findRange(int[] range);

    int count();
    
}
