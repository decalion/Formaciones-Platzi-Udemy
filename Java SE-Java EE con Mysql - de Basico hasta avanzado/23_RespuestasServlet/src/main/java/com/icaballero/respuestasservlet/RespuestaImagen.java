/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.respuestasservlet;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
public class RespuestaImagen extends HttpServlet {

  

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        response.setContentType("image/jpeg");
        
        String pathWeb = getServletContext().getRealPath("/images/642562.jpg");
        System.out.println(pathWeb);
        File f = new File(pathWeb);
        BufferedImage bi = ImageIO.read(f);
        OutputStream out = response.getOutputStream();
        ImageIO.write(bi, "jpg", out);
        out.close();
        
        
      
    }

 

}
