package controllers;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cementerio;
import models.Cliente;
import models.Moderador;

@WebServlet(urlPatterns = {"/Ingcedula"})
public class Ingcedula extends HttpServlet {
    public static int cedula;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 
        Cementerio cementerio = Cementerio.buscarCementerio(Index.idCementerio);
        request.setAttribute("nombreCementerio",cementerio.getNombre());
        RequestDispatcher view = request.getRequestDispatcher("ingcedula.jsp");
        view.forward(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    Cementerio cementerio = Cementerio.buscarCementerio(Index.idCementerio);        
            cedula = Integer.parseInt(request.getParameter("cedula")); 
            boolean ecliente = Cliente.clienteExiste(cedula, cementerio);
            boolean emoderador = Moderador.modExiste(cedula, cementerio);
            request.setAttribute("nombreCementerio",cementerio.getNombre());
            if(!ecliente && !emoderador){
                request.setAttribute("nombreCementerio", cementerio.getNombre());
                RequestDispatcher view = request.getRequestDispatcher("nuevo.jsp");
                view.forward(request, response);
            }else if(ecliente&&emoderador){
                RequestDispatcher view = request.getRequestDispatcher("ambos.jsp");
                view.forward(request,response);
            }else if(ecliente){
                RequestDispatcher view = request.getRequestDispatcher("cliente.jsp");
                view.forward(request, response);
            }else if(emoderador){
                RequestDispatcher view = request.getRequestDispatcher("moderador.jsp");
                view.forward(request,response);
            }
            
                   
            
    }

}
