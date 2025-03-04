/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectoWeb.Clases;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class reHumanos {
private String Usuario;
private String codMensaje;
private String mensaje;
private String codigoUsuario;
private String codigoPerfil;
private ArrayList<reHumanos> listaUsuarios;

    public String getCodigoUsuario() {
        return codigoUsuario;
    }

    public void setCodigoUsuario(String codigoUsuario) {
        this.codigoUsuario = codigoUsuario;
    }
    
     public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }
    
     public String getCodigoPerfil() {
        return codigoPerfil;
    }

    public void setCodigoPerfil(String codigoPerfil) {
        this.codigoPerfil = codigoPerfil;
    }
    
     public String getCodMensaje() {
        return codMensaje;
    }

    public void setCodMensaje(String codMensaje) {
        this.codMensaje = codMensaje;
    }
    
      public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

     public ArrayList<reHumanos> getListaUsuarios() {
        return listaUsuarios;
    }
      public void setListaUsuarios(ArrayList<reHumanos> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }
    
}
