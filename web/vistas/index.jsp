<%-- 
    Document   : index
    Created on : 6 feb. 2025, 12:58:05
    Author     : User
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
         <!--=========PLUGINS DE Swal PARA ALERTAS==================================-->  
        
        <script src="js/sweetalert2.all.min.js"></script>
        <script src="js/sweetalert2.min.js"></script>
       
    </head>

    <style>
        .Form {
            width: 100%;
            max-width: 400px;
            margin: auto;
        }

        .Form-title {
            color: #00386a;
            margin: 0 0 15px;
        }

        .Form-description {
            color: rgba(#6d6665, 50%) ;
        }

        .Form-fields {
            border-radius: 15px;
            border: 1px solid #c5c1c0;
            background-color: #fff;
            display: flex;
            flex-direction: column;
            padding: 24px 15px;
        }

        .Control-label {
            color: #423e3d;
            font-weight: bold;
            transition: color 300ms ease;
        }

        .Control-requirements {

            background: pink;
            border-top: none;
            margin: -14px 0 15px;
            max-height: 0;
            overflow: hidden;
            transition: all 200ms ease;
            padding: 0 9px;
        }

        .ControlInput {
            border-radius: 3px;
            box-shadow: 0 1px 3px rgba(#c5c1c0, 0%) inset;
            color: #6d6665;
            margin: 0.8em 0;
            border: 1px solid #c5c1c0;
            padding: 0.6em 0.6em;
            transition: box-shadow 300ms ease-out;

            &:hover {
                box-shadow: 0 1px 3px rgba(#c5c1c0, 40%) inset;
            }

            &:focus {
                outline: #2bbee7 auto 3px;
            }


            &:invalid:not(:focus):not(:placeholder-shown) {
                border-color: red;
                border-bottom: none;


                & + .Control-label {
                    color: red;

                    & + .Control-requirements {

                        max-height: 100px;
                        padding: 9px;
                        border: 1px solid red;
                    }
                }

            }

            &:valid:not(:focus):not(:placeholder-shown) {
                border-color: #5fa550;
                & + .Control-label {
                    color: #5fa550;
                }
            }


        }

        .Control-requirements--email,
        .ControlInput--email {
            order: -1;
        }

        .Control-label--email {
            order: -2;
        }

        .ControlInput--password {
            order: 0;
            padding-right: 50px;
        }

        .Control-label--password {
            order: -1;
            margin-bottom: -32px;
        }
        .Control-label--showPassword {
            width: 32px;
            position: relative;
            top: 52px;
            left: 100%;
            text-align: right;
            margin-left: -36px;

        }

        .Form-submit {
            border: 1px solid #e7542b;
            background-color: #e7542b;
            border-radius: 3px;
            color: #fff;
            display: block;
            width: 100%;
            max-width: 100%;
            pointer-events: none;
            opacity: 0.6;
            cursor: default;
            transition: opacity 300ms ease-out, max-width 150ms ease-out;
            outline: none;
            position: relative;
            margin: auto;

            &:hover {
                background-color: darken(#e7542b, 10%);
            }
            &:active {
                background-color: darken(#e7542b, 20%);
                max-width: 50px;
                overflow: hidden;
                text-indent: 300px;

                .Button-spinner {
                    opacity: 1;
                }
            }

            .ControlInput--email:valid ~ .ControlInput--password:valid ~ & {
                cursor: pointer;
                pointer-events: auto;
                opacity: 1;
            }
        }
                    
        .Button-spinner {
            position: absolute;
            top: 50%;
            left: 50%;
            margin-left: -13px;
            margin-top: -13px;
            opacity: 0;
        }

        .show-password {
            display: none;

            &:checked {


                & ~ .ControlInput--password {
                    text-security: disc;
                    -webkit-text-security: disc;
                    -moz-text-security: disc;
                }

                & ~ .Control-label--showPassword {
                    .svg-toggle-password {

                        .closed-eye {
                            opacity: 1;
                            transition: opacity 300ms ease, height 400ms ease;
                            width: 4px;
                            height: 44px;
                        }
                    }
                }
            }
        }

        .svg-toggle-password {
            fill: rgba(#008ed6, 50%);

            .closed-eye {
                opacity: 0;
                height: 0;
            }
        }

        .Button {
            padding: 10px;
            user-select: none;
        }


        .spinner {
            animation: dash 2s linear infinite;
            animation-direction: normal;
        }

        @keyframes dash {
            0% {
                stroke-dashoffset: 0;
                stroke-dasharray: 150.6 100.4;
            }
            50% {
                stroke-dasharray: 1 250;
            }
            100% {
                stroke-dashoffset: 502;
                stroke-dasharray: 150.6 100.4;
            }
        }

        @keyframes spinner-in {
            0% {
                opacity: 0;
            }
            20%, 80% {
                opacity: 1;
            }
            100% {
                opacity: 0;
            }
        }


        html {
            box-sizing: border-box;
            height: 100%;
        }

        body {
            background-color: #f1f2f1;
            background-image: linear-gradient(#e7e8e7, #f1f2f1);
            display: flex;
            min-height: 100%;
        }

        *, *:before, *:after {
            box-sizing: inherit;
        }
    </style>

    <body>
        <form action="#login" class="Form">
            <h1 class="Form-title">Login</h1>
            <!--   <p class="Form-description">This form will allow you to login and validate with HTML5 + CSS.</p>-->
            <div class="Form-fields">
                  <label for="email"
                       class="Control-label Control-label--email"
                       >Usuario</label>
                <input type="text"
                       id="user"
                       class="ControlInput ControlInput--email"
                       placeholder="USERNAME"
                       aria-label="Username"
                       aria-describedby="basic-addon1"
                       autocomplete="off" 
                       required=""
                      
                       >
              <!--  
              <input type="text" id="user" class="form-control form-control-lg text-uppercase" placeholder="USERNAME" aria-label="Username" aria-describedby="basic-addon1" autocomplete="off" required="">
              -->
              
                <input type="checkbox"
                       id="show-password"
                       class="show-password"
                       >

                <label for="show-password"
                       class="Control-label Control-label--showPassword"
                       >

                    <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 48 48" width="32" height="32" class="svg-toggle-password" title="Toggle Password Security">
                    <title>Hide/Show Password</title>
                    <path d="M24,9A23.654,23.654,0,0,0,2,24a23.633,23.633,0,0,0,44,0A23.643,23.643,0,0,0,24,9Zm0,25A10,10,0,1,1,34,24,10,10,0,0,1,24,34Zm0-16a6,6,0,1,0,6,6A6,6,0,0,0,24,18Z"/>
                    <rect x="20.133" y="2.117" height="44" transform="translate(23.536 -8.587) rotate(45)" class="closed-eye"/>
                    <rect x="22" y="3.984" width="4" height="44" transform="translate(25.403 -9.36) rotate(45)" style="fill:#fff" class="closed-eye"/>
                    </svg>
                </label>
                
                <label for="password"
                       class="Control-label Control-label--password"
                       >Contraseña</label>

                <input type="password"
                       id="clave"
                       placeholder="PASSWORD"
                       autocomplete="off"
                       autocapitalize="off"
                       autocorrect="off"
                       required=""
                       pattern=".{6,}"
                       class="ControlInput ControlInput--password"
                       >
                
                <!--    <input type="password" id="clave" class="form-control form-control-lg text-uppercase" placeholder="PASSWORD" aria-label="Password" aria-describedby="basic-addon1" required="" autocomplete="off">  -->

                

                <div class="Control-requirements">
                    Must contain at least 6 characters. We did this for your own sake.
                </div>


                <button type="submit" class="Button Form-submit" onclick="validarLogin()">
                    Ingresar
                    
                    <!--  
                    <svg width='26px' height='26px' xmlns="http://www.w3.org/200    0/svg" viewBox="0 0 100 100" preserveAspectRatio="xMidYMid" class="Button-spinner">
                    <rect x="0" y="0" width="100" height="100" fill="none" class="bk"></rect>
                    <circle cx="50" cy="50" r="40" stroke="#fff" fill="none" stroke-width="18" stroke-linecap="round"></circle>
                    <circle cx="50" cy="50" r="40" stroke="#e7542b" fill="none" stroke-width="9" stroke-linecap="round" class="spinner"></circle>
                    </svg>
                    -->
                </button>


            </div>
        </form>
      <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
       <script src="js/cargando.js"></script>
    </body>
    
    <script>
            $(document).ready(async function () {

                                            $('#user').on('keypress', function (event) {
                                                if (event.which === 13) {
                                                    if ($('#user').val().length > 0 && $('#clave').val().length > 0) {  /* tienen contenido, se llama a la función validarLogin().*/
                                                        validarLogin();
                                                    } else if ($('#user').val().length > 0) { //Si solo el campo de usuario tiene contenido, el foco se mueve al campo de la contraseña
                                                        event.preventDefault();
                                                        $('#clave').focus();
                                                    }
                                                }
                                            });

                                            $('#clave').on('keypress', function (event) {
                                                if (event.which === 13) {
                                                    if ($('#user').val().length > 0 && $('#clave').val().length > 0) {
                                                        validarLogin();
                                                    } else if ($('#clave').val().length > 0) {
                                                        event.preventDefault();
                                                        $('#user').focus();
                                                    }
                                                }
                                            });

                                        });
                                        
                                        
                                           function validarLogin() {
                                               console.log("llego a la funcion de validaLogin");
                                               
                                            const user = $("#user").val();
                                            const clave = $("#clave").val();
                                            if (user.trim() === '' || user.indexOf(' ') !== -1) { //trim quita los espacios en blanco0
                                                console.log("mensaje para valiadar user de login");
                                                mensajeAlertas('POR FAVOR, COMPLETE TODOS LOS CAMPOS, NO DEBEN CONTENER ESPACIOS', '', 3);
                                            } else if (clave.trim() === '' || clave.indexOf(' ') !== -1) {  //verifica si hay espacio vacio ''  si hay retorna ese indice y lo iguala a -1 , es es diferente de -1 entonces no hay ninguna cadena vacia 
                                                mensajeAlertas('POR FAVOR, COMPLETE TODOS LOS CAMPOS, NO DEBEN CONTENER ESPACIOS', '', 3);
                                            } else {
                                                Login();
                                               console.log("paso todas validaciones se va a ir a la funcion de login");
                                            }
                                        }

                                        function Login() {
                                            alert("llego a login");
                                            const user = $("#user").val();
                                            const clave = $("#clave").val();
                                            $.ajax({
                                                type: 'POST',
                                                url: '../reHumanosServlet?Accion=Login',
                                                data: 'user=' + user + '&clave=' + clave,
                                                beforeSend: function () {
                                                }, success: function (resultado) {
                                                    const res = $.trim(resultado);
                                                    const rtp = res.split("_");
                                                    console.log("separacion split" + rtp);
                                                     console.log(rtp);
                                                    const ini = rtp[0];
                                                    if (ini == 1) {
                                                        alert("se redirige a pagina de inicio de sesion");
                                                        window.location.href = "layout/empresa.jsp?pagina=INICIO";   //explicame esta parte del codigo 
                                 
                                                       // msjFinal(rtp[0], rtp[1]);
                                                    } else {
                   
                                                         msjFinal(rtp[0], rtp[1]);
                                                    }
                                                }, complete: function () {
                                                }
                                            });
                                        }
                                        
                                         
    </script>    
       
</html>
