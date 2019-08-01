/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Rectangulo;

/**
 *
 * @author ismael
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
        //Processamos la peticion
        //1.Processamos los parametros
        String accion = request.getParameter("accion");
        
        //2.Creamos los JavaBeans a compartir
        Rectangulo recRequest = new Rectangulo(1, 2);
        Rectangulo recSession = new Rectangulo(3, 4);
        Rectangulo recApplication = new Rectangulo(5, 6);
       
        if("agregaVariables".equals(accion)){
            //3.Compartimos las variables en el alcance seleccionado.
            
            //Alcance Request
            request.setAttribute("rectanguloRequest", recRequest);
            
            //Alcance session
            HttpSession session = request.getSession();
            session.setAttribute("rectanguloSession", recSession);
            
            //Alcance application
            ServletContext application = this.getServletContext();
            application.setAttribute("rectanguloApplication", recApplication);
            
            //Agregamos un mensaje
            request.setAttribute("mensaje", "Las variables fueron agregadas");
            
            //4.Redireccionamos al JSP Seleccionado
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }else if("listarVariables".equals(accion)){
            
            //4.Unicamente redireccionamos ya no agregamos variables
            //y se desplegaran solamente las que sigan disponible
            request.getRequestDispatcher("/WEB-INF/alcanceVariables.jsp").forward(request, response);
        }else{
            //4.Redireccionamos a la pagina de inicio
            request.setAttribute("mensaje", "Accion no proporcionada o desconocida");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
      
        
       
    }

   
  
}
