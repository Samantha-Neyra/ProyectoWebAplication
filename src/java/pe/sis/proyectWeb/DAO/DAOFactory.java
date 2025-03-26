/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.DAO;

//import pe.sis.proyectWeb.OracleDAO.OracleDAOFactory;
import pe.sis.proyectWeb.OracleDAO.SqlDAOFactory;

/**
 *
 * @author User
 */
public  abstract class DAOFactory {
     public static final int MYSQL = 1;
        public static final int ORACLE = 2;
        public static final int DB2 = 3;
        public static final int SQLSERVER = 4;
        public static final int XML = 5;

        public static SqlDAOFactory getDAOFactory(int whichFactory) {
            switch (whichFactory) {
                case SQLSERVER:
                    return new SqlDAOFactory();
                /*case SQLSERVER:
                        return new SqlServerDAOFactory();
                   case ORACLE:
                        return new OracleDAOFactory();
                    case DB2:
                        return new Db2DAOFactory();
                    case SQLSERVER:
                        return new SqlServerDAOFactory();
                    case XML:
                        return new XmlDAOFactory();*/
                default:
                    return null;
            }
        }
      public abstract reHumanosDAO getReHumanosDAO();
}
