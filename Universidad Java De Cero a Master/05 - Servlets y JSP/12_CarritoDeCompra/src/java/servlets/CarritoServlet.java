/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
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
@WebServlet(name = "CarritoServlet", urlPatterns = {"/CarritoServlet"})
public class CarritoServlet extends HttpServlet {



    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
       response.setContentType("text/html;charset=UTF-8");
       
       //Processamos el articulo
       String articuloNuevo= request.getParameter("articulo");
       
       //creamos o recuperamos la session
        HttpSession sesion = request.getSession();
       
        //Recuperamos la lista de articulos
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");
        
       if(articulos == null){
           articulos = new ArrayList<>();
           sesion.setAttribute("articulos", articulos);
       }
       //Yatenemos la lista de articulos.
       //Agregamos el nuevo articulo
       if(articuloNuevo !=null && !articuloNuevo.trim().equals("")){
           articulos.add(articuloNuevo);
           
       }
       
       try(PrintWriter out = response.getWriter()){
           
           out.println("<h1>Lista de articulos</h1>");
           out.println("<br>");
           
           for (String articulo : articulos){
               out.println("<li>" + articulo + "</li>");
               
           }
           out.println("<br>");
           out.println("<a href='/CarritoDeCompra'>Regresar </a>");
           
       }
       
       
    }


}
