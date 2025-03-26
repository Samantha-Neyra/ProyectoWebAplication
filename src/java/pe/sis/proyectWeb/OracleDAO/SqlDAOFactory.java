/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.OracleDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.sql.DataSource;
import pe.sis.proyectWeb.DAO.reHumanosDAO;

/**
 *
 * @author USER
 */
public class SqlDAOFactory {
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
                System.out.println("LLEGA A CONEXION SQL SERVER");
                /*
                conexion = DriverManager.getConnection(
                        "jdbc:sqlserver://localhost:1433;databaseName=bdprueba;encrypt=false",  
                        "usersql",  
                        "root2"); 
                */
                 conexion = DriverManager.getConnection(
                "jdbc:sqlserver://localhost:1433;databaseName=bdProyectoWeb;encrypt=false",  
                        "sqlUser",  //"ELCLAN", "ELCL4n#159": Son el usuario y la contraseña de la base de datos.
                        "root33"); //
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

    public reHumanosDAO getReHumanosDAO() {
        return new reHumanosSqlDAO();
    }
}
