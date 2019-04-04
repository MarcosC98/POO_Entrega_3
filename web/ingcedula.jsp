<%@ include file="header.jsp" %>

<main role="main">

      <div class="jumbotron">
        <div class="container">
          <h1 class="display-3">${nombreCementerio}</h1>
          <p>Ingrese su cedula por favor</p><br>
        </div>
      </div>
    
    <table align="center"> 
        <form method="POST" action="./Ingcedula">            
            <tr>
                <td>
                    <center>Cedula:   </center>
                </td>
                
                <td>
                    <input type="number" name="cedula" maxlength="50" required> 
                </td>
            </tr>
            <tr>
                <div style="text-align:center;">
                    <input type="submit" name="Ingresar" value="Ingresar"/>
                </div>
            </tr>
        </form>
    </table>
    
</main>
<%@ include file="footer.jsp" %>
