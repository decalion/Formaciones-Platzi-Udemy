
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
@WebServlet(name = "GeneracionExcelServlet", urlPatterns = {"/GeneracionExcelServlet"})
public class GeneracionExcelServlet extends HttpServlet {

 
  
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // processRequest(request, response);
       
        try (PrintWriter out = response.getWriter()) {
            //Especificamos el tipo de documento de respuesta (MIME)
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("Content-Disposition", "attachment; filename=excelEjemplo.xls");
            //Para un uso mas profesional https://poi.apache.org
            
            response.setHeader("Pragma", "no-cache");
            response.setHeader("Cache-Control", "no-store");
            response.setDateHeader("Expires", -1);
            
            //Desplegamos el contenido en un excel
            out.println("\t"+"Valores");
            out.println("1");
            out.println("2");
            out.println("=SUMA(A2:A3)");
            
            
        }
       
       
    }

}
 



