/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import EJB.usuariosFacadeLocal;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.usuarios;

/**
 *
 * @author gueps
 */
@Named
@ViewScoped
public class UsuarioControlador implements Serializable{
    private usuarios usuario;
    
    @EJB
    private usuariosFacadeLocal usuarioEJB;
    
    @PostConstruct
    public void init(){
        usuario = new usuarios();
    }
    public void insertarUsuario(){
        try{
            usuarioEJB.create(usuario);
        }catch(Exception e){
            System.out.println("Error al insertar usuario a la base de datos" + e.getMessage());
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
