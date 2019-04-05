<%@ include file="header.jsp" %>

<main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">  PERFIL MODERADOR  </h1>
        </div>
      </div>
    
    <table align="center"> 
        <form method="POST" action="./ver_tumbas">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="1. Ver Tumbas."/>
                    <p> </p>
                </div>
            </tr>
        </form> 
        
        <form method="POST" action="./registrar_moderador">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="2. Registrar Moderador"/>
                    <p> </p>
                </div>
            </tr>
        </form>

        <form method="POST" action="./mostrar_moderadores">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="3. Mostrar Moderadores."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./reportar_muerte">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="4. Reportar Muerte de Cliente"/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./clientes_a_cargo">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="5. Clientes a tu cargo."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./despedir_moderador">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="6. Despedir Moderador."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./renunciar_cargo">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="7. Renunciar al cargo de Moderador."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./Registro">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="8. Ingresar con otro documeto."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
        <form method="POST" action="./Registro">            
            <tr>
                <div style="text-align:center;">
                    <p> </p>
                    <input type="submit" name="nombreMod" value="9. Ingresar a otro cementerio."/>
                    <p> </p>
                </div>
            </tr>
        </form>
        
    </table>
    
    <c:if test="${!empty noValido}"> <center>${noValido} no es una opción valida</center></c:if>
    <c:if test="${!empty msjDatos}"> <center>${msjDatos}</center></c:if>
</main>
<%@ include file="footer.jsp" %>
