/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ismael
 */
@WebServlet(name = "SessionServlet", urlPatterns = {"/SessionServlet"})
public class SessionServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      //  processRequest(request, response);
      response.setContentType("text/html;charset=UTF-8");
      HttpSession sesion = request.getSession();
      String titulo = null;
      
      //Pedimos el atributo y verificamos si existe
      Integer contadorVisitas = (Integer) sesion.getAttribute("contadorVisitas");
      
      if(contadorVisitas == null){
          contadorVisitas = new Integer(1);
          titulo ="Bienvenido por primer vez";
      }else{
          titulo = "Bienvenido Nuevamente";
          contadorVisitas +=1;
      }
      
      //En cualquier caso agregamos el valor del contador a la sesion
      sesion.setAttribute("contadorVisitas", contadorVisitas);
      
      PrintWriter out= response.getWriter();
      out.println("Titulo " + titulo);
      out.println("<br>");
      out.println("Nº Accesos al recurso " + contadorVisitas);
      out.println("<br>");
      out.println("ID de la session: " + sesion.getId());
      
      
      
      
    }


 
}
