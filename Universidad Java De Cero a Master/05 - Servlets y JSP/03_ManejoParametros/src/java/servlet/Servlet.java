/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Ismael Caballero
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        PrintWriter out= response.getWriter();
        out.println("<html>");
        out.println("<body>");
        out.println("Metodo doGet no soportado en el servlet");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        //Leemos los paremetros del formulario
        //por default el formulñario es de tipo GET
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        //Se envia al log del servidor glassfish
        System.out.println("Usuario: " + usuario);
        System.out.println("Password: " +password);
        
        //Se envia a la salida del servidor web.
       PrintWriter out = response.getWriter();
       out.println("<html>");
       out.println("<body>");
       out.println("El nombre del usuario es : " + usuario + "<br>");
       out.println("El nombre de password es: " +password  +"<br>");
       out.println("</body>");
       out.println("</html>");
       out.close();
       
        
    }


}
