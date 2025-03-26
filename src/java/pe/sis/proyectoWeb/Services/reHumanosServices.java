/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectoWeb.Services;

import pe.sis.proyectWeb.DAO.DAOFactory;
//import pe.sis.proyectWeb.DAO.DAOFactory;
import pe.sis.proyectWeb.DAO.reHumanosDAO;
import pe.sis.proyectWeb.OracleDAO.SqlDAOFactory;
import pe.sis.proyectoWeb.Clases.reHumanos;

/**
 *
 * @author User
 */
public class reHumanosServices {

    SqlDAOFactory fabrica = DAOFactory.getDAOFactory(DAOFactory.SQLSERVER);
    reHumanosDAO objReHumanosDAO;

    public reHumanosServices() {
        this.objReHumanosDAO = fabrica.getReHumanosDAO();
    }

    public reHumanos listaDatosUsuario(String codUsuario, String codEstado) {
        reHumanos lista = null;
          System.out.println("codUsuario  listaDatosUsuario reHumanosService(service)"+codUsuario);
              System.out.println("codEstado  listaDatosUsuario reHumanosService(service)"+codEstado);
        System.out.println("SERVICE reHumanosService(ListaDatosUsuario)");
        try {
            
            lista = objReHumanosDAO.listaDatosUsuario(codUsuario, codEstado);
           
        } catch (Exception e) {
            System.out.println("ERROR EN SERVICE(reHumanosService)>>>(ListaDatosUsuario) : " + e.getMessage());
        }
        return lista;
    }

    public reHumanos Login(String usuario, String pass) {
        System.out.println("usuario reHumanosService(Login)"+usuario);
        System.out.println("pass reHumanosService(Login)"+pass);
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
