package com.icaballero.controler;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.icaballero.interfaces.RequestHandler;

/**
 * Servlet implementation class Controller
 */
public class Controler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Map<String, RequestHandler> controladores;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controler() {
        super();
        // TODO Auto-generated constructor stub
    }

    
	

    /**
	 * Método que se ejecuta durante la inicialización del Servlet (tras su
	 * instanciación).
	 * Inicializa todos aquellos atributos necesarios para ofrecer sus servicios:
	 * 		- controladores: para gestionar las peticiones de servicios
	 * 
	 * @throws ServletException
	 */
	public void init() throws ServletException {
    	
    	// Inicializamos el hashmap
    	controladores = new HashMap<String, RequestHandler>();
    	controladores.put("/login.do", new LoginHandler());
    	controladores.put("/registerEventV.do", new RegisterEventHandle());
    	controladores.put("/unregisterEvent.do", new UnregisterEventHandle());
    	controladores.put("/logout.do", new LogoutHandle());
    	controladores.put("/update.do", new UpdateHandle());
    	controladores.put("/register.do", new RegisterHandle());
    	controladores.put("/search.do", new SearchHandle());
    	controladores.put("/DeletedEvent.do", new DeletedEventHandle());
    	controladores.put("/UpdateFormEvent.do", new UpdateEventHandle());
    	controladores.put("/saveUpdateEvent.do", new SaveUpdateEvent());
    	controladores.put("/registerEvent.do", new RegisterEvent());
    	controladores.put("/EventNameDesc.do", new OrderDescEventNameHandle());
    	controladores.put("/EventNameAsc.do", new OrderAscEventNameHandle());
	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		processRequest(request, response);
	}
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
		    throws ServletException, IOException {
		        
		        // Obtenemos el manejador asociado al evento ocurrido
		        RequestHandler rh = (RequestHandler) controladores.get(request.getServletPath());
		        
		       
		        // Comprobamos si se obtuvo correctamente el manejador
		        if (rh == null) {
		            // Mostramos el error en caso de no cargarse correctamente
		            response.sendError(HttpServletResponse.SC_NOT_FOUND);
		        } else {
		            
		            // Obtenemos la URL resultante de ejecutar el manejador
		            String viewUrl = rh.handleRequest(request, response);
		            if (viewUrl == null) {
		                // Nada
		            } else {
		                // El RequestHandler correspondiente nos dira que vista utilizar
		                request.getRequestDispatcher(viewUrl).forward(request, response);
		            }
		        }
		    }
		    

}
