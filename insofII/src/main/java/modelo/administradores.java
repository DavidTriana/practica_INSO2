/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author gueps
 */

@Entity
@Table(name="administradores")
public class administradores implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int idAdministradores;
    
    @Column(name="email")
    private String email;
    
    @Column(name="contrasenia")
    private String contrasenia;
    
    @OneToMany(mappedBy="administrador", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<usuarios> usuarios;


    public int getIdAdministradores() {
        return idAdministradores;
    }

    public void setIdAdministradores(int idAdministradores) {
        this.idAdministradores = idAdministradores;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + this.idAdministradores;
        hash = 47 * hash + Objects.hashCode(this.email);
        hash = 47 * hash + Objects.hashCode(this.contrasenia);
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
        final administradores other = (administradores) obj;
        if (this.idAdministradores != other.idAdministradores) {
            return false;
        }
        if (!Objects.equals(this.email, other.email)) {
            return false;
        }
        if (!Objects.equals(this.contrasenia, other.contrasenia)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "administradores{" + "idAdministradores=" + idAdministradores + ", email=" + email + ", contrasenia=" + contrasenia + '}';
    }
    
    
}
