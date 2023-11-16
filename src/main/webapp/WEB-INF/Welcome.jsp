<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script type="text/javascript">
		var ws;
      	function ouvertureWS(){
           if ("WebSocket" in window) 
           { 
        	  ws = new WebSocket("ws://localhost:8080/WebSocketServeur/formation"); 
              ws.onmessage = function (message){
            	  console.log("J'ai recu un message : " + message.data);
            	 
              }; 
              ws.onopen = function(event) 
              {  
            	  console.log("Connexion ouverte"); 
              }; 
              ws.onclose = function() 
              {  
            	console.log("Fermeture de la connection");
                
              };     
              
              
           }          
           else 
           { 
              alert("Non supporté"); 
           } 
      	}
        function lancerMessage(){
        	ws.send("une formation; autre exemple");
        }
        
        function closeWS(){
        	ws.close();
        }
        
     
        </script> 

<a href="http://localhost:8080/WebSocketClient/appel">Envoyer un message en Java</a>
<button onclick="ouvertureWS()">Demarrer</button>
<button onclick="lancerMessage()">Envoyer un message</button>
<button onclick="closeWS()">Arreter</button>




</body>
</html>