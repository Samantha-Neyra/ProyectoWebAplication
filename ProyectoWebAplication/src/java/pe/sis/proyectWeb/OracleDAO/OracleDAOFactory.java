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
                /*conexion = DriverManager.getConnection(
                        "jdbc:oracle:thin:@192.168.1.2:1521:BDELCLAN",
                        "ELCLAN",
                        "CLAN#95123");*/
                conexion = DriverManager.getConnection(
                        //"jdbc:oracle:thin:@192.168.1.6:1521:BDELCLAN",
                        "jdbc:sqlserver://localhost:1433;databaseName=bdprueba",  //jdbc:oracle:thin:: Especifica que se utiliza el driver Thin de Oracle.     -     //@SERVIDOR05:1521:BDELCLAN: Indica el servidor, puerto y nombre de la base de datos.
                        "usersql",  //"ELCLAN", "ELCL4n#159": Son el usuario y la contraseña de la base de datos.
                        "root2"); //
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
