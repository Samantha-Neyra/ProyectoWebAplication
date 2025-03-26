/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.sis.proyectoWeb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import pe.sis.proyectoWeb.Clases.reHumanos;
import pe.sis.proyectoWeb.Services.reHumanosServices;

/**
 *
 * @author User
 */
public class reHumanosServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String param = request.getParameter("Accion");
        System.out.println("SERVLET ReHumanos(Accion): " + param);
        if (null != param) {
            switch (param) {
                case "listaDatosUsuario":
                    listaDatosUsuario(request, response);
                    break;
                case "Login":
                    Login(request, response);
                    break;

            }
        }

    }

    public void listaDatosUsuario(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //<editor-fold defaultstate="collapsed" desc="ListarLevantamiento" >
        System.out.println("SERVLET credito(ListarLevantamiento): ");
        try {
            response.setContentType("text/html;charset=UTF-8");
            reHumanosServices reHumanosServices = new reHumanosServices();
            HttpSession session = request.getSession(true);
            String codUsuario = request.getParameter("codUsuario");
         
            String codEstado = request.getParameter("codEstado");
            // Imprimir los valores de los parámetros en la consola
            //System.out.println("Valor de codUsuario: " + codUsuario);
            //System.out.println("Valor de codSede: " + codSede);
            //System.out.println("Valor de codArea: " + codArea);
            //System.out.println("Valor de codEstado: " + codEstado);

            reHumanos listageneral = reHumanosServices.listaDatosUsuario(codUsuario, codEstado);

            ArrayList<reHumanos> objreHumanos = listageneral.getListaGeneral();
            JSONArray json = new JSONArray();
            for (reHumanos objeto : objreHumanos) {
                /*
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("codUsuario", objeto.getCodigoUsuario() != null ? objeto.getCodigoUsuario() : '-');
                jsonObject.put("usuario", objeto.getUsuario() != null ? objeto.getUsuario() : '-');
                jsonObject.put("nomUsuario", objeto.getNombreUsuario() != null ? objeto.getNombreUsuario() : '-');
                jsonObject.put("apePUsuario", objeto.getApePaternoUsuario() != null ? objeto.getApePaternoUsuario() : '-');
                jsonObject.put("apeMUsuario", objeto.getApeMaternoUsuario() != null ? objeto.getApeMaternoUsuario() : '-');
                jsonObject.put("desTipDOI", objeto.getDescTipoDOI() != null ? objeto.getDescTipoDOI() : '-');
                jsonObject.put("numTipDOI", objeto.getNumeroDOI() != null ? objeto.getNumeroDOI() : '-');
                jsonObject.put("desEmail", objeto.getEmail() != null ? objeto.getEmail() : '-');
                jsonObject.put("desEmailEmp", objeto.getEmailEmpresarial() != null ? objeto.getEmailEmpresarial() : null);
                jsonObject.put("desEmailPass", objeto.getEmailPassword() != null ? objeto.getEmailPassword() : null);
                jsonObject.put("desDireccion", objeto.getDireccion() != null ? objeto.getDireccion() : '-');
                jsonObject.put("fInicio", objeto.getFinicio() != null ? objeto.getFinicio() : '-');
                jsonObject.put("desArea", objeto.getDescArea() != null ? objeto.getDescArea() : '-');
                jsonObject.put("codPerfil", objeto.getCodigoPerfil() != null ? objeto.getCodigoPerfil() : '-');
                jsonObject.put("desCargo", objeto.getDesCargo() != null ? objeto.getDesCargo() : '-');
                jsonObject.put("estado", objeto.getEstado() != null ? objeto.getEstado() : '-');
                jsonObject.put("desSucursal", objeto.getDesSucursal() != null ? objeto.getDesSucursal() : '-');
                jsonObject.put("codCajaUsu", objeto.getCodCajaUsu() != null ? objeto.getCodCajaUsu() : '-');

                json.put(jsonObject);
                */
            }

            response.getWriter().write(json.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
        //</editor-fold >listaDatosUsuario
    }

    private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SERVLET USUARIO(Login)");
        String txtUsuario = request.getParameter("user");
        System.out.println(txtUsuario);
        String txtContrasena = request.getParameter("clave");
        System.out.println(txtContrasena);
        String res;

        reHumanosServices servicios = new reHumanosServices();
        System.out.println("SERVLET USUARIO(Login)" + txtUsuario);
        System.out.println("entrando al service");
        reHumanos seguridad = servicios.Login(txtUsuario, txtContrasena);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        System.out.println("RETORNO DE SQL SERVER");

        System.out.println(seguridad.getCodMensaje());
        //System.out.println(seguridad.getListaUsuarios());
        if ((seguridad.getCodMensaje()).equals("1")) {
            for (reHumanos u : seguridad.getListaUsuarios()) {
                HttpSession session_actual = request.getSession();
                session_actual.setAttribute("codigoUser", u.getCodigoUsuario());
                session_actual.setAttribute("usuario", u.getUsuario());
                session_actual.setAttribute("nombreUsuario", u.getNombreUsuario());
                //session_actual.setAttribute("codPerfil", u.getCodigoPerfil());
                /**
                 * ** redireccion de pagina de session ala pagina de inicio**
                 */
                session_actual.setAttribute("linMo", "../layout/home/inicio.jsp");
                session_actual.setAttribute("codMo", "1");

                System.out.println("Cod Usuario: " + u.getCodigoUsuario() + " Usuario: " + u.getUsuario());

            }

            res = seguridad.getCodMensaje() + '_' + seguridad.getMensaje();
        } else {
            res = seguridad.getCodMensaje() + '_' + seguridad.getMensaje();
        }
        System.out.println("resultado Login: " + res);
        System.out.println("seguridad: " + seguridad.getCodMensaje());
        //pw.print("<input type='hidden' name='inicio' id='inicio' value='" + seguridad.getCodMensaje() + "'>");
        pw.print(res);
    }
}
