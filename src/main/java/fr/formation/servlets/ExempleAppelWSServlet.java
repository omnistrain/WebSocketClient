package fr.formation.servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.websocket.ContainerProvider;
import jakarta.websocket.DeploymentException;
import jakarta.websocket.Session;
import jakarta.websocket.WebSocketContainer;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import fr.formation.websocket.FormationEndPoint;

/**
 * Servlet implementation class ExempleAppelWSServlet
 */
public class ExempleAppelWSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ExempleAppelWSServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		WebSocketContainer conteneur = ContainerProvider.getWebSocketContainer();
		try {
			Session session = conteneur.connectToServer(FormationEndPoint.class, new URI("ws://localhost:8080/WebSocketServeur/formation"));
			
			session.getBasicRemote().sendText("Super formation WS; un descriptif");
			session.close();
		
		} catch (DeploymentException | IOException | URISyntaxException e) {
			
			e.printStackTrace();
		} 
		response.sendRedirect("http://localhost:8080/WebSocketClient/");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
