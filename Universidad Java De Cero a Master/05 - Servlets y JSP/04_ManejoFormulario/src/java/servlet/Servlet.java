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
 * @author ismael
 */
@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

       response.setContentType("text/html;charset=UTF-8");
       PrintWriter out = response.getWriter();
       String usuario = request.getParameter("usuario");
       String password = request.getParameter("password");
       //El elemento tecnologia puede tener varios valores
       String[] tecnologias = request.getParameterValues("tecnologia");
       String genero = request.getParameter("genero");
       String ocupaccion = request.getParameter("ocupacion");
       //El componente musica puede tener multiples valores
       String[] musica = request.getParameterValues("musica");
       String comentarios = request.getParameter("comentarios");
       
       out.println("<html>");
       out.println("<head>");
       out.println("<title> Resultado Servlet </title>");
       out.println("</head>");
       out.println("<body>");
       out.println("<h1> Parametros procesados por el servlet: </h1>");
       
       out.println("<table border='1'>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Usuario:");
       out.println("</td>");
       out.println("<td>");
       out.println(usuario);
       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Password:");
       out.println("</td>");
       out.println("<td>");
       out.println(password);
       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Tecnologias:");
       out.println("</td>");
       out.println("<td>");
       for(String tecnologia : tecnologias){
            out.println(tecnologia);
            out.println(" / ");
        }

       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Genero:");
       out.println("</td>");
       out.println("<td>");
       out.println(genero);
       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Ocupacion:");
       out.println("</td>");
       out.println("<td>");
       out.println(ocupaccion);
       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Musica favorita:");
       out.println("</td>");
       out.println("<td>");
       if(musica != null){
           for(String m: musica){
               out.println(m);
               out.println(" / ");
           }
       }
       out.println("</td>");
       out.println("</tr>");
       
       out.println("<tr>");
       out.println("<td>");
       out.println("Comentarios:");
       out.println("</td>");
       out.println("<td>");
       out.println(comentarios);
       out.println("</td>");
       out.println("</tr>");
       
       out.println("</table>");
       out.println("</body>");
       out.println("</html>");
       out.close();
       
    }


}
