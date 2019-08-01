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
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Servlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Servlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Creamos la variables para processar el titulo y el mensaje
            String title= null, mensaje=null;
            //Detectamos el tipo de navegador
            String tipoNavegador = request.getHeader("User-Agent");
            System.out.println("Tipo navegador: " + tipoNavegador);
            
            //Verificamos tipo de navegador y personalizamos el mensaje
            if(tipoNavegador !=null && tipoNavegador.contains("Trident")){
                title = "Navegador  Internet Explorer";
                mensaje  ="Estas Navegando con Internet Explorer";
            }else if(tipoNavegador !=null && tipoNavegador.contains("Firefox")){
                title = "Navegador  FireFox";
                mensaje  ="Estas Navegando con FireFox";
            }else if(tipoNavegador !=null && tipoNavegador.contains("Chrome")){
                title = "Navegador  Chrome";
                mensaje  ="Estas Navegando con Chrome";
            }
            
            out.println("<html>");
            out.println("<head>");
            out.println("<title>"+title +"</title>"); 
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + mensaje +"</h1>");
            out.println("</body>");
            out.println("</html>");
            
        }

       
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    
}
