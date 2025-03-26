<%-- 
    Document   : menu-superior
    Created on : 17 mar. 2025, 18:18:17
    Author     : USER
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<% HttpSession session_actual = request.getSession(true);%>
<input type="hidden" name="coUser" id="codUser" value="<%=session_actual.getAttribute("codigoUser")%>">
<input type="hidden" name="nomUser" id="nomUser" value="<%=session_actual.getAttribute("usuario")%>">

<header class="topbar" data-navbarbg="skin5">
    <nav class="navbar top-navbar navbar-expand-md navbar-dark">
        <div class="navbar-header col-2" data-logobg="skin5" style="overflow: hidden">
            <a class="navbar-brand" style="height: 4rem !important;" onclick="direcPagina(1, 8, 'INICIO', '', '../layout/home/inicio.jsp', 0, 0)">
                <span class="logo-text m-auto" id="logo-large">
                    <img src="../../assets/images/logoMakitaSAC2.png" alt="homepage" class="light-logo" style="width: 12rem; top: -0.875rem; position: relative;"/>
                </span>
            </a>
            <a class="nav-toggler waves-effect waves-light d-block d-md-none" href="javascript:void(0)">
                <i class="ti-menu ti-close"></i>
            </a>
        </div>

        <div class="navbar-collapse collapse" id="navbarSupportedContent" data-navbarbg="skin5">
            <ul class="navbar-nav float-start me-auto">
                <li class="nav-item">
                    <span class="nav-link text-white">FECHA: <span id="fecActual"></span></span>
                </li>
            </ul>

            <ul class="navbar-nav float-end">
                <!-- Perfil de usuario (1) -->
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle text-muted waves-effect waves-dark pro-pic" href="#" id="navbarDropdown1" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                        <img src="../../assets/images/usuario.png" alt="user" class="rounded-circle" width="31">
                        <span><%= session_actual.getAttribute("usuario")%></span>
                    </a>
                    <ul class="dropdown-menu dropdown-menu-end user-dd animated" aria-labelledby="navbarDropdown1">
                        <li> <!-- Se agregó esta línea -->
                            <a class="dropdown-item" href="#" onclick="miperfil();">Mi Perfil</a>
                        </li> 
                    </ul>
                </li> 


            </ul>
        </div>
                    
    </nav>
                    
</header>
                    
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script src="/ProyectoWebAplication/vistas/js/cargando.js"></script>

<script>
    // Función para mostrar la fecha actual
    document.getElementById("fecActual").innerText = new Date().toLocaleDateString();
    

</script>



