package controllers;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import models.Cementerio;
import models.Ubicacion;
import models.Lapida;
import models.Cliente;

@WebServlet(urlPatterns = {"/Adquirir_lapida"})
public class Adquirir_lapida extends HttpServlet {

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
        RequestDispatcher view = request.getRequestDispatcher("creacion_lapida.jsp");
        view.forward(request, response); 
        

    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Cementerio cementerio = Cementerio.buscarCementerio(Index.idCementerio);
        String contrasena = request.getParameter("contrasena");
        String epitafio = request.getParameter("epitafio");
        boolean privacidad = false;
        if(request.getParameter("privacidad").equals("0")){
            privacidad = false;
        }
        if(request.getParameter("privacidad").equals("1")){
            privacidad = true;
        }
        int indice = Integer.parseInt(request.getParameter("indice"));
        if(Ubicacion.revisarDisponibilidadUbicacion(cementerio, indice)){
            Ubicacion ubicacion = new Ubicacion(indice,cementerio);
            Lapida lapida = new Lapida(Registro.visitante, privacidad, ubicacion, cementerio, epitafio, null);
            Cliente cliente = new Cliente(Registro.visitante, contrasena, lapida);
            request.setAttribute("nombre",Registro.visitante.getNombre());
            request.setAttribute("fechaNac",request.getParameter("fechaNac"));
            request.setAttribute("cedula",Ingcedula.cedula);
            //Enviar demás atributos a la vista de menú cliente(Hace falta programar)
        }else{
            request.setAttribute("mensaje","Esta ubicación se encuentra ocupada, escoja otra por favor");
        }
        request.setAttribute("nombreCementerio",Cementerio.buscarCementerio(Index.idCementerio).getNombre());
        RequestDispatcher view = request.getRequestDispatcher("creacion_lapida.jsp");
        view.forward(request, response);   
            }
    }

