/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */
// =====================================
// =====================================
// MENSAJE PARA RESPUESTA DE PETICIONES - AJAX 

function msjFinal(codMsj, desMsj) {
    let icon = 'error';

    if (codMsj == "1") {
        icon = 'success';
    } else if (codMsj == "2") {
        icon = 'warning';
    }

    Swal.fire({
        icon: icon,
        text: desMsj,
        showConfirmButton: false,
        timer: (codMsj == "1") ? 3500 : undefined
    });
}

function mensajeAlertas(mensaje, title, cod) {
    console.log("Llegó a mensajeAlertas");
    var icon = '';
    var confirmarBtnColor = '#7066e0';

    switch (cod) {
        case 1: icon = 'success'; break;
        case 2: icon = 'error'; break;
        case 3: icon = 'warning'; break;
        case 4: icon = 'info'; break;
        case 5: icon = 'question'; break;
    }

    Swal.fire({
        title: title,
        text: mensaje,
        icon: icon,
        confirmButtonColor: confirmarBtnColor,
        confirmButtonText: 'CERRAR'
    });
}

function cerrarsession() {
    $.ajax({
        type: 'POST',
        url: '../../mantenimientoServlet?Accion=cerrarsession',
        data: "",
        beforeSend: function () {},
        success: function (resultado) {},
        complete: function () {
            window.location.href = "../index.jsp";
        }
    });
}

function miperfil() {
    alert("LLEGO A MI PERFIL");
    $.ajax({
        url: '/ProyectoWebAplication/vistas/layout/reHumanos/perfil.jsp',  // Ruta absoluta corregida
        beforeSend: function () {},
        success: function (data) {
            $("#content-pages").html(data); // Solo necesitas hacer una asignación
        },
        complete: function () {}
    });
}
