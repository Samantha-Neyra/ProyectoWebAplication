/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package pe.sis.proyectWeb.OracleDAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import pe.sis.proyectWeb.DAO.reHumanosDAO;
import pe.sis.proyectoWeb.Clases.reHumanos;

/**
 *
 * @author USER
 */
public class reHumanosSqlDAO implements reHumanosDAO {

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
            cn = SqlDAOFactory.obtenerConexion(base);

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
                    usuario.setCodigoUsuario(rs.getString("CODUSUARIO"));
                    usuario.setUsuario(rs.getString("USUARIO"));
                    usuario.setNombreUsuario(rs.getString("NOMBRECOMPLETO"));
                    lista.add(usuario);   //explicame esta parte delc codigo
                }
            }

            System.out.println("(1) ERROR SQL SERVER: " + cs.getString(3));
            System.out.println("(2) ERROR SQL SERVER: " + cs.getString(4));

            // Configurar el objeto con la información obtenida
            usuarios1.setListaUsuarios(lista);   //explicame esta parte del codigo
            usuarios1.setCodMensaje(cs.getString(3)); //explicame esta parte del codigo
            usuarios1.setMensaje(cs.getString(4));  //explicame esta parte del codigo

        } finally {
            if (rs != null) {
                rs.close();
            }
            if (cs != null) {
                cs.close();
            }
            if (cn != null) {
                cn.close();
            }
        }

        return usuarios1; //explicame esta parte del codigo    ¿que retorna ???
    }
    

    public reHumanos listaDatosUsuario(String codUsuario, String codEstado) throws Exception {
        reHumanos reHumanos = null;
        //reHumanos reHumanos = null;
        //<editor-fold defaultstate="collapsed" desc="listaDatosUsuario" >
        /*
        System.out.println("SQLDAO SEGURIDAD(listaDatosUsuario)");
        ArrayList<reHumanos> listarGeneral;
        reHumanos reHumanos = new reHumanos();
        Connection cn = null;
        String base = "elclan";
        CallableStatement cs;
        ResultSet rs;

        try {

            String sql = "{call PKG_REHUMANOS.USP_LISTA_USUARIO(?,?,?,?,?,?,?)}";
            cn = OracleDAOFactory.obtenerConexion(base);
            cs = cn.prepareCall(sql);
            cs.setInt(1, Integer.valueOf(codUsuario));
            cs.setInt(2, Integer.valueOf(codEstado)); 
            cs.registerOutParameter(5, OracleTypes.CURSOR);
            cs.registerOutParameter(6, OracleTypes.VARCHAR);
            cs.registerOutParameter(7, OracleTypes.VARCHAR);
            cs.execute();

            rs = (ResultSet) cs.getObject(5);
            listarGeneral = new ArrayList<>();

            while (rs.next()) {
                reHumanos objAdjudicaciones = new reHumanos();

                objAdjudicaciones.setCodigoUsuario(rs.getString("COD_USUARIO"));
                objAdjudicaciones.setUsuario(rs.getString("USUARIO"));
                objAdjudicaciones.setNombreUsuario(rs.getString("USU_NOMBRE"));
                objAdjudicaciones.setApePaternoUsuario(rs.getString("USU_APATERNO"));
                objAdjudicaciones.setApeMaternoUsuario(rs.getString("USU_AMATERNO"));
                objAdjudicaciones.setDescTipoDOI(rs.getString("DES_TDOC"));
                objAdjudicaciones.setNumeroDOI(rs.getString("USU_NUMDOC"));
                objAdjudicaciones.setEmail(rs.getString("USU_EMAIL"));
                objAdjudicaciones.setEmailEmpresarial(rs.getString("EMAIL_LAB"));
//                objAdjudicaciones.setEmailPassword(rs.getString("PASWOR_CLAB"));
                objAdjudicaciones.setDireccion(rs.getString("USU_DIRECC"));
                objAdjudicaciones.setFinicio(rs.getString("F_INICIO"));
                objAdjudicaciones.setDescArea(rs.getString("AREA"));
                objAdjudicaciones.setCodigoPerfil(rs.getString("COD_PERFIL"));
                objAdjudicaciones.setDesCargo(rs.getString("CARGO"));
                objAdjudicaciones.setEstado(rs.getString("ESTADO"));
                objAdjudicaciones.setDesSucursal(rs.getString("DES_SUCURSAL"));
                objAdjudicaciones.setCodCajaUsu(rs.getString("COD_CAJAUSU"));
                //System.out.println("SERVLET reHumanos(listarAreasSede): ");

                listarGeneral.add(objAdjudicaciones);
            }
            reHumanos.setListaGeneral(listarGeneral);

            System.out.println(
                    "ORACLE: PKG_REHUMANOS.USP_LISTA_USUARIO > CodMensaje: " + (String) cs.getObject(6) + " Mensaje: " + (String) cs.getObject(7));

        } catch (Exception e) {
            System.out.println("EXCEPTION PKG_REHUMANOS.USP_LISTA_USUARIO =>>>>>>>>>>>> " + e);
        } finally {
            cn.close();
        }*/
        return reHumanos;
        //</editor-fold >   
    }

}

