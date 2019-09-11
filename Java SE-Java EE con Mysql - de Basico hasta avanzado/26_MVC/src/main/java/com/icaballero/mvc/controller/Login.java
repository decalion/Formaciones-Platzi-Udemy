/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.icaballero.mvc.controller;

import com.icaballero.mvc.model.LoginBean;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ismael
 */
public class Login extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //Obtener los datos del formularios
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        //Validar los datos
        LoginBean bean = new LoginBean();
        bean.setName(name);
        bean.setPassword(password);

        boolean status = bean.validate();

        //Guardar los datos en un atributo para poder usarlo en otras paginas jsp
        request.setAttribute("user", bean);

        
        //Redirigir a una pagina o otro segun la validacion
        if (status) {

            RequestDispatcher rd = request.getRequestDispatcher("succes.jsp");
            rd.forward(request, response);

        } else {
            RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
            rd.forward(request, response);
        }

    }

}
