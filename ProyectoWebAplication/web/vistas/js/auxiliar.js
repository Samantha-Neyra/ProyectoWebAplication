/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/JavaScript.js to edit this template
 */


function mensajeAlertas(mensaje, title, cod) {
    console.log("llego a mensajeAlertas");
    var icon = '';
    var confirmarBtnColor = '';
    switch (cod) {
        case 1:
            icon = 'success';
            confirmarBtnColor = '#7066e0';
            break;
        case 2:
            icon = 'error';
            confirmarBtnColor = '#7066e0';
            break;
        case 3:
            icon = 'warning';
            confirmarBtnColor = '#7066e0';
            break;
        case 4:
            icon = 'info';
            confirmarBtnColor = '#7066e0';
            break;
        case 5:
            icon = 'question';
            confirmarBtnColor = '#7066e0';
            break;
    }
    Swal.fire({
        title: title,
        text: mensaje,
        icon: icon,
        confirmButtonColor: confirmarBtnColor,
        confirmButtonText: 'CERRAR'
    });
}