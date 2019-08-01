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
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
@WebServlet(name = "CookieServlet", urlPatterns = {"/CookieServlet"})
public class CookieServlet extends HttpServlet {

    

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
        //Suponenmos que el ussuario visita por primera vez nuestro sitio web
        boolean nuevoUsuario = true;
        
        //Obtenemos todas las cookies
        Cookie[] cookies = request.getCookies();
        
        if(cookies != null){
            
            for (Cookie c : cookies) {
                if(c.getName().equals("visitanteRecurrente") && c.getValue().equals("si") ){
                    nuevoUsuario = false;
                    break;
                }
            }
        }
        String mensaje = null;
        if(nuevoUsuario){
            Cookie visitanteCookie = new Cookie("visitanteRecurrente", "si");
            
            response.addCookie(visitanteCookie);
            mensaje = "Gracias por visitar nuestro sitio";
        }else{
                mensaje = "Gracias por visitar de NUEVO nuestro sitio";
        }
        
         response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            
            out.println("Mensaje : " + mensaje);
            
        }
        
    }




}
