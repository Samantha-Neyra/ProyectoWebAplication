/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectoWeb.Services;

import pe.sis.proyectWeb.DAO.DAOFactory;
import pe.sis.proyectWeb.DAO.reHumanosDAO;
import pe.sis.proyectoWeb.Clases.reHumanos;

/**
 *
 * @author User
 */
public class reHumanosServices {
      DAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
    reHumanosDAO objReHumanosDAO;

    public reHumanosServices() {
        this.objReHumanosDAO = fabrica.getReHumanosDAO();
    }
    
    public reHumanos Login(String usuario, String pass) {
        reHumanos seguridad = null;
        System.out.println("SERVICE reHumanosService(Login)");
        try {
            seguridad = objReHumanosDAO.Login(usuario, pass);
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(validarUsuario) : " + e.getMessage());
        }
        return seguridad;
    }
}
