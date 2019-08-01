
package servlet;

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
@WebServlet(name = "ContadorVisitasServlet", urlPatterns = {"/ContadorVisitasServlet"})
public class ContadorVisitasServlet extends HttpServlet {


   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       
       //Declaramos la variabler contador
       int contador = 0;
       
       Cookie[] cookies = request.getCookies();
       
       if(cookies !=null){
           
           for (Cookie c : cookies) {
               if(c.getName().equals("contadorVisitas")){
                   try{
                       
                       contador = Integer.parseInt(c.getValue());
                   }catch(NumberFormatException e){
                       contador = 0;
                   }
               }
           }
       }
       
       contador++;
       Cookie c = new Cookie("contadorVisitas", Integer.toString(contador));
       c.setMaxAge(3600); // 3600 segundos
       response.addCookie(c);
       
       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       out.println("Contador de visitas de cada cliente: " + contador);

    }





}
