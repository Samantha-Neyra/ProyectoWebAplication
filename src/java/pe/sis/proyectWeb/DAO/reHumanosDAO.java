/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.DAO;

import pe.sis.proyectoWeb.Clases.reHumanos;

/**
 *
 * @author User
 */
public interface reHumanosDAO {

    public reHumanos Login(String usuario, String contrasena) throws Exception;

    public reHumanos listaDatosUsuario(String codUsuario, String codEstado) throws Exception;
}
