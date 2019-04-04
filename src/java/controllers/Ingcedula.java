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

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
        RequestDispatcher view = request.getRequestDispatcher("ingcedula.jsp");
        view.forward(request, response);        
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {        
            int cedula = Integer.parseInt(request.getParameter("cedula")); 
            Cementerio cementerio = Cementerio.buscarCementerio(Index.idCementerio);
            boolean ecliente = Cliente.clienteExiste(cedula, cementerio);
            boolean emoderador = Moderador.modExiste(cedula, cementerio);
            request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
            if(!ecliente && !emoderador){
                request.setAttribute("noCedula", cedula);
                RequestDispatcher view = request.getRequestDispatcher("ingcedula.jsp");
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
