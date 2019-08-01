/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
@WebServlet(name = "Header", urlPatterns = {"/Header"})
public class Header extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Header</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Header at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       
       //Processamos los headers
       String metodoHttp = request.getMethod();
       String uri = request.getRequestURI();
       
       out.println("<html>");
       out.println("<head>");
       out.println("<title>Headers HTTP</title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1>Headers HTTP </h1>");
       out.println("Metodo Http: " +metodoHttp);
       out.println("<br>");
       out.println("URI Solicitado " +uri);
       out.println("<br>");
       
       //Procesamos algunos cabeceros que son parte de la peticion
       out.println("<br>");
       out.println("Host " +request.getHeader("Host"));
       out.println("<br>");
       out.println("Navegador: " + request.getHeader("User-Agent"));
       //Processamos otros cabeceros
       //Estos valores pueden variar segun el navegador
       out.println("<br>");
       out.println("<br>");
       Enumeration cabeceros = request.getHeaderNames();
        while (cabeceros.hasMoreElements()) { 
            String nombreCabecero = (String) cabeceros.nextElement();
            out.println("<br>" + nombreCabecero + "</br>");
            out.println(request.getHeader(nombreCabecero));
            out.println("<br>");
        }
        out.println("</body>");
        out.println("</html>");
       
        out.close();
       
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }


}
