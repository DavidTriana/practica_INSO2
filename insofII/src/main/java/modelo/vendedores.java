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
@Table(name="vendedores")

public class vendedores implements Serializable{
    
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idVendedor;
    
    @Column(name="nombre")
    private String nombre;
    
    @Column(name="telefono")
    private String telefono;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contraseña")
    private String contraseña;
    
    @Column(name="tarjetaBanco")
    private String tarjetaBanco;
    
    @JoinColumn(name="administradores_idAdministradores", referencedColumnName="idAdministrador")
    @ManyToOne
    private administradores administrador;
    
    
    public int getIdVendedor() {
        return idVendedor;
    }

    public void setIdVendedor(int idVendedor) {
        this.idVendedor = idVendedor;
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

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
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
        hash = 59 * hash + this.idVendedor;
        hash = 59 * hash + Objects.hashCode(this.nombre);
        hash = 59 * hash + Objects.hashCode(this.telefono);
        hash = 59 * hash + Objects.hashCode(this.email);
        hash = 59 * hash + Objects.hashCode(this.contraseña);
        hash = 59 * hash + Objects.hashCode(this.tarjetaBanco);
        hash = 59 * hash + Objects.hashCode(this.administrador);
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
        final vendedores other = (vendedores) obj;
        if (this.idVendedor != other.idVendedor) {
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
        if (!Objects.equals(this.contraseña, other.contraseña)) {
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
        return "vendedores{" + "idVendedor=" + idVendedor + ", nombre=" + nombre + ", telefono=" + telefono + ", email=" + email + ", contrase\u00f1a=" + contraseña + ", tarjetaBanco=" + tarjetaBanco + ", administrador=" + administrador + '}';
    }

    
    
}
