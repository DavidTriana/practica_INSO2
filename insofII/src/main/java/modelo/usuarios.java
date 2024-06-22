/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author gueps
 */

@Entity
@Table(name="usuarios")
public class usuarios implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idUsuario;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @Column(name="direccion")
    private String direccion;
    
    @Column(name="tarjetaBanco")
    private String tarjetaBanco;
    
    @JoinColumn(name="administradores_idAdministradores", referencedColumnName="idAdministradores")
    @ManyToOne
    private administradores administrador;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTarjetaBanco() {
        return tarjetaBanco;
    }

    public void setTarjetaBanco(String tarjetaBanco) {
        this.tarjetaBanco = tarjetaBanco;
    }

    public administradores getAdministrador() {
        return administrador;
    }

    public void setAdministrador(administradores administrador) {
        this.administrador = administrador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.idUsuario;
        hash = 71 * hash + Objects.hashCode(this.nombre);
        hash = 71 * hash + Objects.hashCode(this.telefono);
        hash = 71 * hash + Objects.hashCode(this.email);
        hash = 71 * hash + Objects.hashCode(this.contrasenia);
        hash = 71 * hash + Objects.hashCode(this.direccion);
        hash = 71 * hash + Objects.hashCode(this.tarjetaBanco);
        hash = 71 * hash + Objects.hashCode(this.administrador);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final usuarios other = (usuarios) obj;
        if (this.idUsuario != other.idUsuario) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        if (!Objects.equals(this.direccion, other.direccion)) {
            return false;
        }
        if (!Objects.equals(this.tarjetaBanco, other.tarjetaBanco)) {
            return false;
        }
        if (!Objects.equals(this.administrador, other.administrador)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "usuarios{" + "idUsuario=" + idUsuario + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", contrasenia=" + contrasenia + ", direccion=" + direccion + ", tarjetaBanco=" + tarjetaBanco + ", administrador=" + administrador + '}';
    }
    
    
    
}
