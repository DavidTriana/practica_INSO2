/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author david
 */

@Named
@ViewScoped
public class PlantillaBaseControlador implements Serializable{
    
    public void verificarYMostrar() throws IOException{
        Object usuario = FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        
        if(usuario == null){
            String contextPath;
            contextPath = FacesContext.getCurrentInstance().getExternalContext().getApplicationContextPath();
            FacesContext.getCurrentInstance().getExternalContext().redirect(contextPath + "/faces/noPermisos.xhtml");
        }
    }
    
}
