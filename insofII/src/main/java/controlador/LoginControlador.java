/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.usuarios;
import EJB.usuariosFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@Named  //Indicar que la clase esta asociada con un EJB
@ViewScoped //Indicar que solo existe mientras exista la vista asociada
public class LoginControlador implements Serializable {

    private usuarios usuario;

    @EJB    //una por cada objeto
    private usuariosFacadeLocal usuarioEJB;

    @PostConstruct  //esto es lo primero que va a ocurrir
    public void init() {
        usuario = new usuarios();   //reservar memoria para el usuario
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

    public String verificarUsuario() {

        //se verifica en facade si existe un usuario con ese nombre y contrasenia
        try {
            usuario = usuarioEJB.verificarUsuario(usuario);
            if (usuario == null) {
                System.out.println("No existe ese usuario");
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No existe este usuario"));
            } else {
                String navegacion = "privado/usuario/principalUsuario.xhtml?faces-redirect=true";
                System.out.println(usuario.toString());
                return navegacion;
            }
        } catch (Exception e) {
            System.out.println("Error al verificar el usuario " + e.getMessage());
        }
        return null;
    }

}
