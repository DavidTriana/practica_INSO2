/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.enviosFacade;
import EJB.usuariosFacadeLocal;
import java.io.Serializable;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import modelo.envios;
import modelo.usuarios;

/**
 *
 * @author gueps
 */
@Named
@ViewScoped
public class UsuarioControlador implements Serializable {

    private usuarios usuario;

    @EJB
    private usuariosFacadeLocal usuarioEJB;

    @PostConstruct
    public void init() {
        usuario = (usuarios) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
        /*Si el usuario no está en la sesion*/
        if (usuario == null) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Usuario no encontrado en la sesion"));
        }
    }

    public void insertarUsuario() {
        try {
            usuarioEJB.create(usuario);
        } catch (Exception e) {
            System.out.println("Error al insertar usuario a la base de datos" + e.getMessage());
        }
    }

    public void actualizarDatos() {
        try {
            usuarioEJB.edit(usuario);
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "informacion", "Datos actualizados correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "No se pudo actualizar los datos"));

        }
    }

   
    public usuarios getUsuario() {
        return usuario;
    }

    public void setUsuario(usuarios usuario) {
        this.usuario = usuario;
    }

    public usuariosFacadeLocal getUsuarioEJB() {
        return usuarioEJB;
    }

    public void setUsuarioEJB(usuariosFacadeLocal usuarioEJB) {
        this.usuarioEJB = usuarioEJB;
    }

}
