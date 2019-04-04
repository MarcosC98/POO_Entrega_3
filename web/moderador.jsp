<%@ include file="header.jsp" %>

<main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">PERFIL MODERADOR</h1>
        </div>
      </div>
    
    <table align="center"> 
        <form method="POST" action="./Index">            
            <tr>
                <td>
                    <center>Cementerio:  </center>
                </td>
                
                <td>
                    <input type="number" name="idCementerio" maxlength="1" required> 
                </td>
            </tr>
            <tr>
                <div style="text-align:center;">
                    <input type="submit" name="Ingresar" value="Ingresar"/>
                </div>
            </tr>
        </form>
    </table>
    <form method="POST" action="./Datos">
       <div style="text-align:center;">
           <input type="submit" name="datos ficticios" value="Generar datos ficticios"/>
       </div>
    </form>    

    <c:if test="${!empty noValido}"> <center>${noValido} no es una opción valida</center></c:if>
    <c:if test="${!empty msjDatos}"> <center>${msjDatos}</center></c:if>
</main>
<%@ include file="footer.jsp" %>
