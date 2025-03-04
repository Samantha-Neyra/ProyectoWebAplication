/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package pe.sis.proyectoWeb.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
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
                case "Login":
                    Login(request, response);
                    break;
            }
        }

    }
    
    private void Login(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("SERVLET USUARIO(Login)");
        String txtUsuario = request.getParameter("user");
        String txtContrasena = request.getParameter("clave");
        String res;

        reHumanosServices servicios = new reHumanosServices();

        System.out.println("SERVLET USUARIO(Login)" + txtUsuario);
        reHumanos seguridad = servicios.Login(txtUsuario, txtContrasena);
        response.setContentType("text/html");
        PrintWriter pw = response.getWriter();
        System.out.println("RETORNO DE ORACLE");

        if ((seguridad.getCodMensaje()).equals("1")) {
            for (reHumanos u : seguridad.getListaUsuarios()) {
                HttpSession session_actual = request.getSession();
                session_actual.setAttribute("codigoUser", u.getCodigoUsuario());
                session_actual.setAttribute("usuario", u.getUsuario());
                session_actual.setAttribute("codPerfil", u.getCodigoPerfil());
                /**
                 * ** redireccion de pagina de session ala pagina de inicio**
                 */
                session_actual.setAttribute("linMo", "../layout/home/inicio.jsp");
                session_actual.setAttribute("codMo", "1");

                System.out.println("Cod Usuario: " + u.getCodigoUsuario() + " Usuario: " + u.getUsuario());
            }

            res = seguridad.getCodMensaje();
        } else {
            res = seguridad.getCodMensaje() + '_' + seguridad.getMensaje();
        }
        System.out.println("resultado Login: " + res);
        System.out.println("seguridad: " + seguridad.getCodMensaje());
        //pw.print("<input type='hidden' name='inicio' id='inicio' value='" + seguridad.getCodMensaje() + "'>");
        pw.print(res);
    } 
}
