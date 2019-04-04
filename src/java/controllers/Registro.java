package controllers;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cementerio;
import models.Persona;
import java.time.*;

@WebServlet(urlPatterns = {"/Registro"})

public class Registro extends HttpServlet {   
    public static Persona visitante;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
        RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
        view.forward(request, response);   

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String nombre = request.getParameter("nombreV");
        LocalDate fechaNac = LocalDate.parse(request.getParameter("fechaNac"));
        Period periodo = Period.between(fechaNac,LocalDate.now());
        int edad = periodo.getYears();
        if(edad >= 18 && edad <120){
            visitante = new Persona(nombre,Ingcedula.cedula,Date.valueOf(request.getParameter("fechaNac")), Cementerio.buscarCementerio(Index.idCementerio));
            request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
            request.setAttribute("nombre",nombre);
            request.setAttribute("fechaNac",request.getParameter("fechaNac"));
            request.setAttribute("cedula",Ingcedula.cedula);
            RequestDispatcher view = request.getRequestDispatcher("menuvisitante.jsp");
            view.forward(request, response);   
            
        }else{
            request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
            request.setAttribute("mensaje", "Ingrese una fecha valida");
            RequestDispatcher view = request.getRequestDispatcher("registro.jsp");
            view.forward(request, response);   
        }

    }
}
