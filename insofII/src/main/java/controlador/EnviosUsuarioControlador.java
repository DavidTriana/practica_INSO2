/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.Serializable;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author david
 */

@Named  //Indicar que la clase esta asociada con un EJB
@ViewScoped //Indicar que solo existe mientras exista la vista asociada
public class EnviosUsuarioControlador implements Serializable{
    
    //meter usuario desde la variable global y desde ahi sacar la lista de envios
    
}