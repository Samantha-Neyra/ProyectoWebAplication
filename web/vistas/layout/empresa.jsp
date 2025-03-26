<%-- 
    Document   : empresa
    Created on : 17 mar. 2025, 17:58:50
    Author     : USER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <%
        HttpSession session_actual = request.getSession(true);
        String codUsuario = (String) session_actual.getAttribute("codigoUser");
        String Usuario = (String) session_actual.getAttribute("usuario");
        String link = (String) session_actual.getAttribute("linMo");

        if (Usuario == null) {

            response.sendRedirect("../index.jsp");
            link = "../index.jsp";
        }
        System.out.println("Session Codigo Usuario " + codUsuario);
        System.out.println("Session Usuario: " + Usuario);
    %>
    <!--=========== inclui el archivo de la cabecera css o jquery ====================-->
     
    <jsp:include page="includes/header.jsp" />    
    
    <!-- ==================== Libreria Chart js ======================= -->
    <style>
        canvas {
            padding: 10px;
            min-height: 100px;
        }
        .title {
            color: #575757;
        }
        .footer-main {
            margin-top: 20px;
            padding: 15px 20px;
            background-color: #fff;
            border-top: 1px solid #dee2e6;
            color: #869099;
        }
        .contenido{
            width: 97% !important;
            background: #fff !important;
            margin: auto;
            margin-top: 10px;
            border-radius: 10px;
            box-shadow: 0 0 1px rgba(0,0,0,.125), 0 1px 3px rgba(0,0,0,.2);
            padding-top: 20px;
        }
        .sidebar-item .collapse{
            transition: background-color 0.3s;
            transition: max-height 0.3s;
        }
    </style>
    <body>
       

        <main id="main-wrapper" data-layout="vertical" data-navbarbg="skin5" data-sidebartype="full"
              data-sidebar-position="absolute" data-header-position="absolute" data-boxed-layout="full">

            <!-- ========incluir menu superior======= -->
           <jsp:include page="includes/menu-superior.jsp" /> 
        </main>  
        
    </body>

    <div class="content-loader visually-hidden" id="ico-loader">
        <div class="loader">
        </div>
    </div>
    
    <div id="content-pages" class="contenido">                   

    </div>

    <script>

        //$(document).ready(async function () {

       //});
    </script>

</html>
