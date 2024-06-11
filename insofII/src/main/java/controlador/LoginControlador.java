package controlador;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import modelo.usuarios;
import modelo.vendedores;
import EJB.usuariosFacadeLocal;
import EJB.vendedoresFacadeLocal;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author david
 */
@Named
@ViewScoped
public class LoginControlador implements Serializable {

    private usuarios usuario;
    private vendedores vendedor;

    @EJB
    private usuariosFacadeLocal usuarioEJB;
    @EJB
    private vendedoresFacadeLocal vendedorEJB;

    @PostConstruct
    public void init() {
        usuario = new usuarios();
        vendedor = new vendedores();
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

    public vendedores getVendedor() {
        return vendedor;
    }

    public void setVendedor(vendedores vendedor) {
        this.vendedor = vendedor;
    }

    public vendedoresFacadeLocal getVendedorEJB() {
        return vendedorEJB;
    }

    public void setVendedorEJB(vendedoresFacadeLocal vendedorEJB) {
        this.vendedorEJB = vendedorEJB;
    }

    public String verificarUsuario() {
        String navegacion = "";
        try {
            // Verificar si es un usuario
            usuarios usuarioVerificado = usuarioEJB.verificarUsuario(usuario);
            if (usuarioVerificado != null) {
                navegacion = "privado/usuario/principalUsuario.xhtml?faces-redirect=true";
                System.out.println(usuarioVerificado.toString());
                return navegacion;
            }
            
            // Verificar si es un vendedor
            vendedores vendedorVerificado = new vendedores();
            vendedorVerificado.setNombre(usuario.getNombre());
            vendedorVerificado.setContraseña(usuario.getContrasenia());
            vendedorVerificado = vendedorEJB.verificarVendedor(vendedorVerificado);
            if (vendedorVerificado != null) {
                navegacion = "privado/vendedor/principalVendedor.xhtml?faces-redirect=true";
                System.out.println(vendedorVerificado.toString());
                return navegacion;
            }

            // Si no es ni usuario ni vendedor
            System.out.println("No existe ese usuario o vendedor");
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "No existe este usuario o vendedor"));
        } catch (Exception e) {
            System.out.println("Error al verificar el usuario " + e.getMessage());
        }
        return null;
    }
}
