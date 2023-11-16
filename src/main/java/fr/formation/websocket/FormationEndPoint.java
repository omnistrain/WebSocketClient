package fr.formation.websocket;

import jakarta.websocket.ClientEndpoint;
import jakarta.websocket.OnClose;
import jakarta.websocket.OnMessage;
import jakarta.websocket.OnOpen;
import jakarta.websocket.Session;

@ClientEndpoint
public class FormationEndPoint {
	
	  @OnMessage 
	  public void onMessage(String message, Session session){ 
	        System.out.println("le client a reçu le message suivant :" +message); 
	  } 
	    
	  @OnClose 
	  public void onClose(Session session){
		  System.out.println("Communication terminée"); 
	  } 
	    
	  @OnOpen 
	  public void onOpen(Session session){ 
	        System.out.println("Communication établie"); 
	  } 

}
