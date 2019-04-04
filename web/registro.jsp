<%@ include file="header.jsp" %>

<main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">${nombreCementerio}</h1>
          <p>Ingrese todos los datos por favor(Debe ser mayor de edad, y tener menos de 120 años)</p><br>
        </div>
      </div>
    
    <table align="center"> 
        <form method="POST" action="./Registro">            
            <tr>
                <td>
                    <center>Nombre completo:   </center>
                </td>
                
                <td>
                    <input type="text" name="nombreV" maxlength="50" required> 
                </td>
                
                <td>
                    <center>Fecha de nacimiento   </center>
                </td>
                
                <td>
                    <input type="date" name="fechaNac" required>
                </td>
            </tr>
            <tr>
                <div style="text-align:center;">
                    <input type="submit" name="Registrarme" value="Registrarme"/>
                </div>
            </tr>
        </form>
    </table>
    <p><c:if test="${!empty mensaje}"> <center>${mensaje}</center></c:if></p>
</main>
<%@ include file="footer.jsp" %>
