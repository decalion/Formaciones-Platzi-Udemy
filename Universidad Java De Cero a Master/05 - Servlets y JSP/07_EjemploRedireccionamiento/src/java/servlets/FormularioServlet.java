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

/**
 *
 * @author ismael
 */
@WebServlet(name = "FormularioServlet", urlPatterns = {"/FormularioServlet"})
public class FormularioServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       String usuarioCorrecto = "Ismael";
       String passCorrecto = "1234";
         String usuario = request.getParameter("usuario");
         String password = request.getParameter("password");
         
        try (PrintWriter out = response.getWriter()) {
            
           if(usuarioCorrecto.equalsIgnoreCase(usuario) && passCorrecto.equals(password)){
            
            out.println("<h1>");
            out.println("Datos Correctos");
            out.println("<br>Usuario: " + usuario);
            out.println("<br>Password: " + password);
            out.println("</h1>");
        }else{
               //Respondemos al navegador con un codigo no autorizado
               response.sendError(response.SC_UNAUTHORIZED , "LAS CREDENCALES SON INCORRECTAS");
           }
       
       
      }
    }

   


}
