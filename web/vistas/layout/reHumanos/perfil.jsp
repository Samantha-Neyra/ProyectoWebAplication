<%-- 
    Document   : perfil
    Created on : 20 mar. 2025, 14:06:28
    Author     : USER
--%>

<style>
    .contenido{
        background: #F4F6F9 !important;
        border: 0 !important;
        box-shadow: none !important;
    }
    label.error{
        position: absolute;
        margin-top: 2.1rem;
        right: 0;
    }


</style>

<!-- Example Code -->
<div class="row ms-2">
    <div class="col-3 bg-white shadow me-3 ms-3 border-danger border-top border-4" style="border-radius: 5px" >
        <!--ESTADO ICON-->        
        <div class="d-flex justify-content-end mt-3" id="estado">

        </div>    

        <div class="p-2">
          
            <label for="desUsuario" >USUARIO:</label>
            <input class="form-control rounded-pill mb-2 text-uppercase" id="desUsuario" name="desUsuario" readonly/>

            <label for="desArea">AREA:</label>
            <input class="form-control rounded-pill mb-2 text-uppercase"readonly id="desArea" name="desArea"/>

            <label for="desCargo">CARGO:</label>
            <input class="form-control rounded-pill mb-3 text-uppercase" id="desCargo" name="desCargo" readonly/>

            <div class="text-center mb-2">
                <a href="#">CAMBIAR CONTRASEÑA?</a>
            </div>
        </div>
    </div>

    <div class="col-8  bg-white shadow border-danger border-top border-4 pe-5 ps-5" style="border-radius: 5px">

        <form class="form-horizontal p-3">
            <div class="m-auto">
                <h4 class="col-5 m-auto fw-bold text-center">DATOS GENERALES DEL USUARIO</h4>
            </div>

            <div class="form-group row mt-3 mb-3">
                <label for="desNombre" class="col-lg-2 col-form-label">NOMBRE</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control text-uppercase" id="desNombre" name="desNombre" readonly/>
                </div>
            </div>

            <div class="form-group row mt-3 mb-3">
                <label for="desApellidos" class="col-lg-2 col-form-label">APELLIDOS</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control text-uppercase" id="desApellidos" name="desApellidos" readonly/>
                </div>
            </div>

            <div class="form-group row mt-3 mb-3">
                <label for="desDni" class="col-lg-2 col-form-label">DNI </label>
                <div class="col-lg-10">
                    <input type="text" class="form-control text-uppercase" id="desDni" name="desDni" readonly/>
                </div>
            </div>
            <div class="form-group row mt-3 mb-3">
                <label for="desDireccion" class="col-lg-2 col-form-label">DIRECCION</label>
                <div class="col-lg-10">
                    <input type="text" class="form-control text-uppercase" id="desDireccion" name="desDireccion" readonly/>
                </div>
            </div>

            <div class="form-group row mt-3 mb-3">
                <label for="fecInicio" class="col-lg-2 col-form-label">FEC. INICIO </label>
                <div class="col-lg-10">
                    <input type="date" class="form-control text-uppercase" id="fecInicio" name="fecInicio" readonly/>
                </div>
            </div>

            <div class="form-group row mt-3 mb-3">
                <label for="desCorreo" class="col-lg-2 col-form-label">CORREO</label>
                <div class="col-lg-10">
                    <div class="input-group mb-3 mt-3">
                        <input type="text" class="form-control text-uppercase" id="desCorreo" name="desCorreo" readonly/>
                        <button class="btn btn-success text-white" type="button" id="btnEditarCorreo" name="btnEditarCorreo"  title="EDITAR CORREO" onclick="modalActCorreo()"><i class="fas fa-edit"></i></button>
                    </div>
                </div>
            </div>
        </form>
    </div>
</div>

<script>
  
  
  
    $(document).ready(async () => {
        listarPerfil();
       // UpperCaseInput();
    });
 
   

   



    async function listarPerfil() {
        alert("llego a funcion de listar perfil");
        console.log("codUser:", $('#codUser').val());
        await $.ajax({
            type: 'POST',
            url: '../../reHumanosServlet?Accion=listaDatosUsuario&codEstado=1&codUsuario='+$('#codUser').val(),
            dataType: 'json',
            beforeSend: function () {
            }, success: await function (resultado) {
                $.each(resultado, function (idx, ele) {
                    $('#desUsuario').val(ele?.usuario);
                    $('#desArea').val(ele?.desArea);
                    $('#desCargo').val(ele?.desCargo);

                    $('#desNombre').val(ele?.nomUsuario);
                    $('#desApellidos').val(ele?.apePUsuario + " " + ele?.apeMUsuario);
                    $('#desDni').val(ele?.numTipDOI);
                    $('#desDireccion').val(ele?.desDireccion);
                    $('#fecInicio').val(ele?.fInicio);
                    $('#desCorreo').val(ele?.desEmailEmp);

                    const estado = ele?.estado !== 'ACTIVO' ? `<span class="bg-danger rounded-pill text-white p-2 fw-bold"> INACTIVO </span>` : `<span class="bg-success rounded-pill text-white p-2 fw-bold"> ACTIVO </span>`;
                    $('#estado').html('');
                    $('#estado').append(estado);

                });
            }, complete: function () {
            }
        });
    }

</script>