<%@ include file="header.jsp" %>

<main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">${nombreCementerio}</h1>
          <p><b>Menú de adquisición de lápida</b></p>
          <p>Ingrese todos los datos con * por favor</p><br>
        </div>
      </div>
    
    <table align="center"> 
        <form method="POST" action="./Adquirir_lapida">            
            <tr>
                <td>
                    <center>Contraseña para su cuenta*: </center>
                </td>
                
                <td>
                    <input type="text" name="contrasena" maxlength="50" required> 
                </td>
            </tr>
            <tr>
                <td>
                    <center>Epitafio:  </center>
                </td>
                
                <td>
                    <input type="text" name="epitafio" >
                </td>
            </tr>
            <tr>
                <td>
                    <center>Privacidad*:   </center>
                </td>
                
                <td>
                    <select name = "privacidad" required>
                        <option value ="0">pública</option>
                        <option value ="1">privada</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    <center>Ubicación:  </center>
                </td>
                
                <td>
                    <input type="number" name="indice" >
                </td>
            </tr>
            
            <tr>
                <div style="text-align:center;">
                    <input type="submit" name="Adquirir" value="Adquirir"/>
                </div>
            </tr>
        </form>
    </table>
    <p><c:if test="${!empty mensaje}"> <center>${mensaje}</center></c:if></p>
</main>
<%@ include file="footer.jsp" %>
