package controllers;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cementerio;

@WebServlet(urlPatterns = {"/Index"})
public class Index extends HttpServlet {

    public static int idCementerio;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("cementerios", Datos.texto);
        RequestDispatcher view = request.getRequestDispatcher("index.jsp");
        view.forward(request, response);   

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
            idCementerio = Integer.parseInt(request.getParameter("idCementerio"));
            Cementerio c = Cementerio.buscarCementerio(idCementerio);
            if(c == null){
                request.setAttribute("noValido", idCementerio);
                request.setAttribute("cementerios", Datos.texto);
                RequestDispatcher view = request.getRequestDispatcher("index.jsp");
                view.forward(request, response);               
            }else{
                String nombreCementerio = c.getNombre();
                request.setAttribute("nombreCementerio",nombreCementerio);
                RequestDispatcher view = request.getRequestDispatcher("ingcedula.jsp");
                view.forward(request, response);  
            }
    }
}
