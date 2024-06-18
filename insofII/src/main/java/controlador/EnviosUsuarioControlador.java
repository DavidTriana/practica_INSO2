/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.enviosFacadeLocal;
import EJB.usuariosFacade;
import EJB.usuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import modelo.envios;
import modelo.usuarios;

/**
 *
 * @author david
 */

@Named  //Indicar que la clase esta asociada con un EJB
@ViewScoped //Indicar que solo existe mientras exista la vista asociada
public class EnviosUsuarioControlador implements Serializable{
    
    @EJB
    private enviosFacadeLocal enviosFacade;
    
    @EJB
    private usuariosFacadeLocal usuariosFacade;
    
    @Inject
    private UsuarioControlador usuarioControlador;
    
    private List<envios> enviosUsuario;
    
    @PostConstruct
    public void init(){
        usuarios user = usuarioControlador.getUsuario();
        enviosUsuario = enviosFacade.obtenerEnviosUsuario(user);
    }
    
    public List<envios> getEnviosUsuario(){
        return enviosUsuario;
    }
    
    //meter usuario desde la variable global y desde ahi sacar la lista de envios
 
    public String irCarrito(){
        return "carritoUsuario.xhtml?faces-redirect=true";
    }
    
    public String irProductos(){
        return "productosGeneral.xhtml?faces-redirect=true";
    }
    
    public String irEnviosUsuario(){
        return "enviosUsuario.xhtml?faces-redirect=true";
    }
    
     public String irPrincipal(){
        return "principalUsuario.xhtml?faces-redirect=true";
    }
}
