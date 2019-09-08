/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
public class HolaMundo extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        System.out.println("Ejecutando metodo doGet");
        
       try(PrintWriter w = resp.getWriter()){
           
           w.write("Hola Mundo desde el Servlet");
           
       }catch(Exception e){
           
       }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
         
        System.out.println("Ejecutando metodo doPost");
        
        String email = req.getParameter("email");
        
           try(PrintWriter w = resp.getWriter()){
           
           w.write("Tu email es :" + email );
           
       }catch(Exception e){
           
       }
        
        
    }
    
    
    
    
    
    
}
