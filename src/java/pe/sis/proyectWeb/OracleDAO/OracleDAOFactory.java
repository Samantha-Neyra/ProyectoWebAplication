/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.OracleDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.sql.DataSource;
import javax.swing.JOptionPane;
import pe.sis.proyectWeb.DAO.DAOFactory;
import pe.sis.proyectWeb.DAO.reHumanosDAO;

/**
 *
 * @author User
 */
public class OracleDAOFactory extends DAOFactory {

   static DataSource dataSource = null;

    static {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver"); //Esto asegura que el driver esté disponible en tiempo de ejecución.

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public static Connection obtenerConexion(String base) {
        Connection conexion = null;
//AYUDA GIT
        if (base.equals("proyectWeb")) {
            try {
                System.out.println("LLEGA A CONEXION ORACLE");
                /*
                conexion = DriverManager.getConnection(
                        //"jdbc:oracle:thin:@192.168.1.6:1521:BDELCLAN",
                        "jdbc:sqlserver://localhost:1433;databaseName=bdprueba;encrypt=false", 
                        "usersql",  
                        "root2"); 
                */
                 conexion = DriverManager.getConnection(
                        //"jdbc:oracle:thin:@192.168.1.6:1521:BDELCLAN",
                        "jdbc:sqlserver://192.168.1.8:1433;databaseName=bdProyectoWeb;encrypt=false", 
                        "sqlUser",  
                        "root33"); 
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
//AYUDA 
       
        } else if (base.equals(" ")) {
          System.out.println("ConexionVacia");
        }
        System.out.println("CONECTAR: " + conexion);
        return conexion;
    }

    @Override
    public reHumanosDAO getReHumanosDAO() {
        return new reHumanosOracleDAO();
    }
}
