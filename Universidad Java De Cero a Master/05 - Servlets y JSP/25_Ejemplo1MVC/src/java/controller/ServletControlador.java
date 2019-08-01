/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
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
       // processRequest(request, response);
       
       //1.En este caso no hay necesidad de procesar parametros
       
       //2.Creamos los JavaBean
        Rectangulo rec = new Rectangulo(3,6);
        
        
        //3.Agregamos las Variables en cierto Alcance
        request.setAttribute("mensaje", "Saludos desde el Servlet");
        
        HttpSession session  =request.getSession();
        session.setAttribute("rectangulo", rec);
        
        //4.Redireccionanmos
        RequestDispatcher rd = request.getRequestDispatcher("vista/desplegarVariables.jsp");
        //Se propagan los Objetos resquest y Response
        //para que puedan ser utilizados por el JSP seleccionado
        rd.forward(request, response);
        
        
       
    }

   
  
}
