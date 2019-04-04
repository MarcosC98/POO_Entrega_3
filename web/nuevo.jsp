<%@ include file="header.jsp" %>

<main role="main">

    <div class="jumbotron">
      <div class="container">
        <h1 class="display-3">${nombreCementerio}</h1>
        <p>No hay ningún usuario registrado con esa cedula</p><br>
      </div>
    </div>
        
    <form method="GET" action="./Registro">
        <div style="text-align:center;">
            <input type="submit" name="Registrar con este documento" value="Registrar con este documento"/>
        </div>
    </form>
        
    <form method="GET" action="./Ingcedula">
        <div style="text-align:center;">
            <input type="submit" name="Ingresar con cedula distinta" value="Ingresar con cedula distinta"/>
        </div>
    </form>
        
    <form method="GET" action="./Index">
        <div style="text-align:center;">
            <input type="submit" name="" value="Ingresar a un cementerio distinto"/>
        </div>
    </form>
</main>
<%@ include file="footer.jsp" %>
