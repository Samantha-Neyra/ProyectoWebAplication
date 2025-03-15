/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.OracleDAO;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
//import javax.lang.model.util.Types;
import pe.sis.proyectWeb.DAO.reHumanosDAO;
import pe.sis.proyectoWeb.Clases.reHumanos;

/**
 *
 * @author User
 */
public class reHumanosOracleDAO implements reHumanosDAO  {
    
     public reHumanos Login(String codUsuario, String pass) throws Exception {

    String base = "proyectWeb";
    Connection cn = null;
    CallableStatement cs = null;
    ResultSet rs = null;
    reHumanos usuarios1 = new reHumanos();
    ArrayList<reHumanos> lista = new ArrayList<>();

    System.out.println("LLEGO A SQL SERVER ");
    System.out.println("codUsuario: " + codUsuario);
    System.out.println("pass: " + pass);

    try {
        // Obtener conexión con SQL Server
        cn = OracleDAOFactory.obtenerConexion(base);

        // Llamada al procedimiento almacenado
        String sql = "{ CALL USP_LOGIN(?, ?, ?, ?) }";
        cs = cn.prepareCall(sql);
        cs.setString(1, codUsuario);
        cs.setString(2, pass);
        cs.registerOutParameter(3, Types.VARCHAR); // Código de mensaje
        cs.registerOutParameter(4, Types.VARCHAR); // Mensaje

        // Ejecutar procedimiento
        boolean hasResultSet = cs.execute(); 

        // Si el procedimiento devuelve una tabla, obtenemos el ResultSet
        if (hasResultSet) {
            rs = cs.getResultSet();
            while (rs.next()) {
                reHumanos usuario = new reHumanos();
                usuario.setUsuario(rs.getString("USUARIO"));
                usuario.setNombreUsuario(rs.getString("NOMBRECOMPLETO"));
                lista.add(usuario);
            }
        }

        System.out.println("(1) ERROR SQL SERVER: " + cs.getString(3));
        System.out.println("(2) ERROR SQL SERVER: " + cs.getString(4));

        // Configurar el objeto con la información obtenida
        usuarios1.setListaUsuarios(lista);
        usuarios1.setCodMensaje(cs.getString(3));
        usuarios1.setMensaje(cs.getString(4));

    } finally {
        if (rs != null) rs.close();
        if (cs != null) cs.close();
        if (cn != null) cn.close();
    }

    return usuarios1;
}

     
}
